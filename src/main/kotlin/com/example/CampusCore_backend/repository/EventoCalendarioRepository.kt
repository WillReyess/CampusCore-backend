package com.example.CampusCore_backend.repository

import com.example.CampusCore_backend.entity.EventoCalendario
import com.example.CampusCore_backend.entity.enums.TipoEvento
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.OffsetDateTime

@Repository
interface EventoCalendarioRepository : JpaRepository<EventoCalendario, Long> {
    fun findByIdUsuario(idUsuario: Long): List<EventoCalendario>
    fun findByIdGrupo(idGrupo: Long): List<EventoCalendario>
    fun findByTipoEvento(tipoEvento: TipoEvento): List<EventoCalendario>
    fun findByFechaInicioBetween(desde: OffsetDateTime, hasta: OffsetDateTime): List<EventoCalendario>
}
