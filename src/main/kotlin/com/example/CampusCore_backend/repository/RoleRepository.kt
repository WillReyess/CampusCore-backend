package com.example.CampusCore_backend.repository

import com.example.CampusCore_backend.entity.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository : JpaRepository<Role, Long> {
    fun findByNombre(nombre: String): Role?
    fun existsByNombre(nombre: String): Boolean
}
