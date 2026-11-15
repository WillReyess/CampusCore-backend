package com.example.CampusCore_backend.service

import com.example.CampusCore_backend.dto.RegisterRequest
import com.example.CampusCore_backend.dto.UpdateUserRequest
import com.example.CampusCore_backend.dto.UserResponse
import com.example.CampusCore_backend.dto.toResponse
import com.example.CampusCore_backend.entity.User
import com.example.CampusCore_backend.exception.ConflictException
import com.example.CampusCore_backend.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    @Transactional
    fun register(request: RegisterRequest): UserResponse {
        val correo = request.correo.trim().lowercase()
        if (userRepository.existsByCorreo(correo)) {
            throw ConflictException("No se pudo completar el registro")
        }

        val documento = request.documentoIdentidad?.trim()?.takeIf { it.isNotEmpty() }
        if (documento != null && userRepository.existsByDocumentoIdentidad(documento)) {
            throw ConflictException("No se pudo completar el registro")
        }

        val user = User(
            correo = correo,
            passwordHash = requireNotNull(passwordEncoder.encode(request.password)) {
                "No se pudo generar el hash de la contraseña"
            },
            nombres = request.nombres.trim(),
            apellidos = request.apellidos.trim(),
            documentoIdentidad = documento,
            telefono = request.telefono?.trim(),
            direccion = request.direccion?.trim(),
            fechaNacimiento = request.fechaNacimiento,
            contactoEmergencia = request.contactoEmergencia?.trim()
        )

        return userRepository.save(user).toResponse()
    }

    @Transactional(readOnly = true)
    @PreAuthorize("hasRole('ADMIN')")
    fun findAll(): List<UserResponse> = userRepository.findAll().map { it.toResponse() }

    @Transactional(readOnly = true)
    @PreAuthorize("hasRole('ADMIN') or @userSecurity.isSelf(#id)")
    fun findById(id: Long): UserResponse = getEntity(id).toResponse()

    @Transactional
    @PreAuthorize("hasRole('ADMIN') or @userSecurity.isSelf(#id)")
    fun update(id: Long, request: UpdateUserRequest): UserResponse {
        val user = getEntity(id)

        request.nombres?.let { user.nombres = it.trim() }
        request.apellidos?.let { user.apellidos = it.trim() }
        request.telefono?.let { user.telefono = it.trim() }
        request.direccion?.let { user.direccion = it.trim() }
        request.fechaNacimiento?.let { user.fechaNacimiento = it }
        request.contactoEmergencia?.let { user.contactoEmergencia = it.trim() }

        return userRepository.save(user).toResponse()
    }

    private fun getEntity(id: Long): User =
        userRepository.findByIdOrNull(id)
            ?: throw NoSuchElementException("Usuario con id $id no encontrado")
}
