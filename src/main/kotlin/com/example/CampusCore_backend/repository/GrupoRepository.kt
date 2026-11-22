package com.example.CampusCore_backend.repository

import com.example.CampusCore_backend.entity.Grupo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GrupoRepository : JpaRepository<Grupo, Long> {
    fun findByIdPeriodo(idPeriodo: Long): List<Grupo>
    fun findByIdMateria(idMateria: Long): List<Grupo>
    fun findByIdProfesor(idProfesor: Long): List<Grupo>
    fun findByIdPeriodoAndIdMateria(idPeriodo: Long, idMateria: Long): List<Grupo>
}
