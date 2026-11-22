package com.example.CampusCore_backend.repository

import com.example.CampusCore_backend.entity.AuditoriaLog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuditoriaLogRepository : JpaRepository<AuditoriaLog, Long> {
    fun findByIdUsuario(idUsuario: Long): List<AuditoriaLog>
    fun findByTablaAfectada(tablaAfectada: String): List<AuditoriaLog>
}
