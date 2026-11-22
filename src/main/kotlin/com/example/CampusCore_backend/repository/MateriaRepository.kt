package com.example.CampusCore_backend.repository

import com.example.CampusCore_backend.entity.Materia
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MateriaRepository : JpaRepository<Materia, Long> {
    fun findByCodigo(codigo: String): Materia?
    fun existsByCodigo(codigo: String): Boolean
}
