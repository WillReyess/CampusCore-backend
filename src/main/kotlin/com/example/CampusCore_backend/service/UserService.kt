package com.example.CampusCore_backend.service

import com.example.CampusCore_backend.dto.Requests.RegisterEstudianteRequest
import com.example.CampusCore_backend.dto.Responses.SideBarResponse
import com.example.CampusCore_backend.entity.Estudiante
import com.example.CampusCore_backend.entity.User
import com.example.CampusCore_backend.repository.CarreraRepository
import com.example.CampusCore_backend.repository.EstudianteRepository
import com.example.CampusCore_backend.repository.RoleRepository
import com.example.CampusCore_backend.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.NoSuchElementException

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val roleRepository: RoleRepository,
    private val estudianteRepository: EstudianteRepository,
    private val carreraRepository: CarreraRepository
) {

    @Transactional(readOnly = true)
    fun getSideBar(correo: String): SideBarResponse {
        val correoNormalizado = correo.trim().lowercase()
        val user = userRepository.findByCorreo(correoNormalizado)
            ?: throw NoSuchElementException("Usuario no encontrado")

        val estudiante = estudianteRepository.findByIdUsuario(user.id)
        val carrera = estudiante?.let { carreraRepository.findByIdOrNull(it.idCarrera) }
        val rolPrincipal = user.roles.firstOrNull()?.nombre ?: "ESTUDIANTE"

        return SideBarResponse(
            usuarioId = user.id,
            nombreCompleto = "${user.nombres} ${user.apellidos}",
            correo = user.correo,
            rol = rolPrincipal,
            carnet = estudiante?.carnet,
            carrera = carrera?.nombre
        )
    }

    @Transactional
    fun registrarEstudiante(request: RegisterEstudianteRequest): SideBarResponse {
        val correoNormalizado = request.correo.trim().lowercase()
        val documentoNormalizado = request.documentoIdentidad.trim().takeIf { it.isNotEmpty() }

        // validacion de datos si estan existentes
        if (userRepository.existsByCorreo(correoNormalizado)) {
            throw IllegalArgumentException("El correo ya está registrado")
        }
        if (documentoNormalizado != null && userRepository.existsByDocumentoIdentidad(documentoNormalizado)) {
            throw IllegalArgumentException("El documento de identidad ya está registrado")
        }

        val carrera = carreraRepository.findByIdOrNull(request.idCarrera)
            ?: throw NoSuchElementException("La carrera especificada no existe")

        val rolEstudiante = roleRepository.findByNombre("Estudiante")
            ?: throw NoSuchElementException("El rol ESTUDIANTE no está configurado")

        // Crear y guardar entidad User
        val passwordCodificado = passwordEncoder.encode(request.password)
            ?: throw IllegalStateException("Error al codificar la contraseña")

        val nuevoUsuario = User(
            id = 0,
            correo = correoNormalizado,
            passwordHash = passwordCodificado,
            nombres = request.nombres.trim(),
            apellidos = request.apellidos.trim(),
            documentoIdentidad = documentoNormalizado,
            telefono = request.telefono.trim().takeIf { it.isNotEmpty() },
            direccion = request.direccion.trim().takeIf { it.isNotEmpty() },
            fechaNacimiento = request.fechaNacimiento,
            contactoEmergencia = request.contactoEmergencia.trim().takeIf { it.isNotEmpty() }
        )
        nuevoUsuario.roles.add(rolEstudiante)

        val usuarioGuardado = userRepository.save(nuevoUsuario)

        // Crear y guardar entidad Estudiante vinculada al usuario
        val nuevoEstudiante = Estudiante(
            idUsuario = usuarioGuardado.id,
            idCarrera = carrera.id,
            carnet = request.carnet.trim()
        )
        val estudianteGuardado = estudianteRepository.save(nuevoEstudiante)

        return SideBarResponse(
            usuarioId = usuarioGuardado.id,
            nombreCompleto = "${usuarioGuardado.nombres} ${usuarioGuardado.apellidos}",
            correo = usuarioGuardado.correo,
            rol = rolEstudiante.nombre,
            carnet = estudianteGuardado.carnet,
            carrera = carrera.nombre
        )
    }
}