package com.example.CampusCore_backend.repository

import com.example.CampusCore_backend.entity.Tarea
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TareaRepository : JpaRepository<Tarea, Long> {
    fun findByIdGrupo(idGrupo: Long): List<Tarea>
    fun findByIdEvaluacion(idEvaluacion: Long): List<Tarea>
}
