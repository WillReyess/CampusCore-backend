package com.example.CampusCore_backend.repository

import com.example.CampusCore_backend.entity.HistorialCambioGrupo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HistorialCambioGrupoRepository : JpaRepository<HistorialCambioGrupo, Long> {
    fun findByIdEstudiante(idEstudiante: Long): List<HistorialCambioGrupo>
    fun findByIdGrupoOrigen(idGrupoOrigen: Long): List<HistorialCambioGrupo>
    fun findByIdGrupoDestino(idGrupoDestino: Long): List<HistorialCambioGrupo>
}
