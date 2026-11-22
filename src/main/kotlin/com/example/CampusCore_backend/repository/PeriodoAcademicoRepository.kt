package com.example.CampusCore_backend.repository

import com.example.CampusCore_backend.entity.PeriodoAcademico
import com.example.CampusCore_backend.entity.enums.EstadoPeriodo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PeriodoAcademicoRepository : JpaRepository<PeriodoAcademico, Long> {
    fun findByEstado(estado: EstadoPeriodo): List<PeriodoAcademico>
    fun findByAnio(anio: Int): List<PeriodoAcademico>
}
