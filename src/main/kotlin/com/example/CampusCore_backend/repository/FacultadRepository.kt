package com.example.CampusCore_backend.repository

import com.example.CampusCore_backend.entity.Facultad
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FacultadRepository : JpaRepository<Facultad, Long> {
    fun findByCodigo(codigo: String): Facultad?
    fun findByNombre(nombre: String): Facultad?
    fun existsByCodigo(codigo: String): Boolean
    fun existsByNombre(nombre: String): Boolean
}
