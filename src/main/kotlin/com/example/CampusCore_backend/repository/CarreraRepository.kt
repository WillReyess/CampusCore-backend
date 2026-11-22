package com.example.CampusCore_backend.repository

import com.example.CampusCore_backend.entity.Carrera
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarreraRepository : JpaRepository<Carrera, Long> {
    fun findByCodigo(codigo: String): Carrera?
    fun findByIdFacultad(idFacultad: Long): List<Carrera>
    fun existsByCodigo(codigo: String): Boolean
}
