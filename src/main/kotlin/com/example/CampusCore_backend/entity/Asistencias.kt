package com.example.CampusCore_backend.entity

import com.example.CampusCore_backend.entity.enums.EstadoAsistencia
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(
    name = "asistencias",
    uniqueConstraints = [
        UniqueConstraint(
            name = "asistencias_estudiante_id_horario_sesion_id_fecha_key",
            columnNames = ["estudiante_id", "horario_sesion_id", "fecha"]
        )
    ]
)
class Asistencia(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "estudiante_id", nullable = false)
    var idEstudiante: Long = 0,

    @Column(name = "horario_sesion_id", nullable = false)
    var idHorarioSesion: Long = 0,

    @Column(nullable = false)
    var fecha: LocalDate = LocalDate.now(),

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "text")
    var estado: EstadoAsistencia = EstadoAsistencia.Presente
)
