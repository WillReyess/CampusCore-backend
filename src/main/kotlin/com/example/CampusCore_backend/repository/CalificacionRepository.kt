package com.example.CampusCore_backend.repository

import com.example.CampusCore_backend.entity.Calificacion
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CalificacionRepository : JpaRepository<Calificacion, Long> {
    fun findByIdEstudiante(idEstudiante: Long): List<Calificacion>
    fun findByIdEvaluacion(idEvaluacion: Long): List<Calificacion>
    fun findByIdEvaluacionAndIdEstudiante(idEvaluacion: Long, idEstudiante: Long): Calificacion?
    fun existsByIdEvaluacionAndIdEstudiante(idEvaluacion: Long, idEstudiante: Long): Boolean
}
