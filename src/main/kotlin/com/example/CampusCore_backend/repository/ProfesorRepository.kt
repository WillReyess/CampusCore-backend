package com.example.CampusCore_backend.repository

import com.example.CampusCore_backend.entity.Profesor
import com.example.CampusCore_backend.entity.enums.EstadoProfesor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProfesorRepository : JpaRepository<Profesor, Long> {
    fun findByIdUsuario(idUsuario: Long): Profesor?
    fun findByIdFacultad(idFacultad: Long): List<Profesor>
    fun findByEstado(estado: EstadoProfesor): List<Profesor>
    fun existsByIdUsuario(idUsuario: Long): Boolean
}
