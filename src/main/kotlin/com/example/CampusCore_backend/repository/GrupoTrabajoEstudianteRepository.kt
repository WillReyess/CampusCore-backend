package com.example.CampusCore_backend.repository

import com.example.CampusCore_backend.entity.GrupoTrabajoEstudiante
import com.example.CampusCore_backend.entity.GrupoTrabajoEstudianteId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GrupoTrabajoEstudianteRepository : JpaRepository<GrupoTrabajoEstudiante, GrupoTrabajoEstudianteId> {
    fun findByIdTarea(idTarea: Long): List<GrupoTrabajoEstudiante>
    fun findByIdEstudiante(idEstudiante: Long): List<GrupoTrabajoEstudiante>
    fun existsByIdTareaAndIdEstudiante(idTarea: Long, idEstudiante: Long): Boolean
}
