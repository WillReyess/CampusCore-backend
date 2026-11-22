package com.example.CampusCore_backend.repository

import com.example.CampusCore_backend.entity.HorarioSesion
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HorarioSesionRepository : JpaRepository<HorarioSesion, Long> {
    fun findByIdGrupo(idGrupo: Long): List<HorarioSesion>
    fun findByIdAula(idAula: Long): List<HorarioSesion>
    fun findByIdGrupoAndDiaSemana(idGrupo: Long, diaSemana: Int): List<HorarioSesion>
}
