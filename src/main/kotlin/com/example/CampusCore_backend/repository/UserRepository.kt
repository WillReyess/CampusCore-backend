package com.example.CampusCore_backend.repository

import com.example.CampusCore_backend.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

    fun findByCorreo(correo: String): User?

    fun existsByCorreo(correo: String): Boolean

    fun findByDocumentoIdentidad(documentoIdentidad: String): User?

    fun existsByDocumentoIdentidad(documentoIdentidad: String): Boolean

    fun findByRoles_Nombre(nombre: String): List<User>
}
