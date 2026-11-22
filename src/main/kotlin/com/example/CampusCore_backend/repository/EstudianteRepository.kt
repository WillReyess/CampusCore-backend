package com.example.CampusCore_backend.repository

import com.example.CampusCore_backend.entity.Estudiante
import com.example.CampusCore_backend.entity.enums.EstadoEstudiante
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EstudianteRepository : JpaRepository<Estudiante, Long> {
    fun findByCarnet(carnet: String): Estudiante?
    fun findByIdUsuario(idUsuario: Long): Estudiante?
    fun findByIdCarrera(idCarrera: Long): List<Estudiante>
    fun findByEstado(estado: EstadoEstudiante): List<Estudiante>
    fun existsByCarnet(carnet: String): Boolean
    fun existsByIdUsuario(idUsuario: Long): Boolean
}
