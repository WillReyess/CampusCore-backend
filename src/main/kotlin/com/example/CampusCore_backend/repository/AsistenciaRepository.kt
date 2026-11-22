package com.example.CampusCore_backend.repository

import com.example.CampusCore_backend.entity.Asistencia
import com.example.CampusCore_backend.entity.enums.EstadoAsistencia
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface AsistenciaRepository : JpaRepository<Asistencia, Long> {
    fun findByIdEstudiante(idEstudiante: Long): List<Asistencia>
    fun findByIdHorarioSesion(idHorarioSesion: Long): List<Asistencia>
    fun findByIdEstudianteAndFecha(idEstudiante: Long, fecha: LocalDate): List<Asistencia>
    fun findByIdEstudianteAndEstado(idEstudiante: Long, estado: EstadoAsistencia): List<Asistencia>
}
