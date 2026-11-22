package com.example.CampusCore_backend.config

import com.example.CampusCore_backend.entity.User
import com.example.CampusCore_backend.repository.RoleRepository
import com.example.CampusCore_backend.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class DataInitializer(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val passwordEncoder: PasswordEncoder,

    @Value("\${superadmin.email}")
    private val adminEmail: String,

    @Value("\${superadmin.nombre}")
    private val adminNombre: String,

    @Value("\${superadmin.apellido}")
    private val adminApellido: String,

    @Value("\${superadmin.password}")
    private val adminPassword: String
) : CommandLineRunner {

    private val logger = LoggerFactory.getLogger(DataInitializer::class.java)

    override fun run(vararg args: String?) {
        crearSuperAdminSiNoExiste()
    }

    private fun crearSuperAdminSiNoExiste() {
        // Si ya existe, no hacemos nada (idempotente)
        if (userRepository.existsByCorreo(adminEmail)) {
            logger.info("SuperAdmin ya existe, omitiendo inicialización.")
            return
        }

        // Buscar el rol SuperAdministrador (debe existir por data.sql)
        val rolSuperAdmin = roleRepository.findByNombre("SuperAdministrador")
        if (rolSuperAdmin == null) {
            logger.error("No se encontró el rol 'SuperAdministrador'. Verifica que data.sql se ejecutó correctamente.")
            return
        }

        // Crear el usuario administrador con datos del .env
        val admin = User(
            correo = adminEmail,
            passwordHash = passwordEncoder.encode(adminPassword),
            nombres = adminNombre,
            apellidos = adminApellido
        )
        admin.roles.add(rolSuperAdmin)

        userRepository.save(admin)
        logger.info("SuperAdmin '$adminNombre $adminApellido' creado con correo: $adminEmail")
    }
}
