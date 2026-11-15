package com.example.CampusCore_backend.entity

import com.example.CampusCore_backend.entity.enums.TipoSesion
import jakarta.persistence.*
import java.time.LocalTime

@Entity
@Table(name = "horarios_sesiones")
class HorarioSesion(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "grupo_id", nullable = false)
    var idGrupo: Long = 0,

    @Column(name = "aula_id", nullable = false)
    var idAula: Long = 0,

    @Column(name = "dia_semana", nullable = false)
    var diaSemana: Int = 1,

    @Column(name = "hora_inicio", nullable = false)
    var horaInicio: LocalTime = LocalTime.MIN,

    @Column(name = "hora_fin", nullable = false)
    var horaFin: LocalTime = LocalTime.MIN,

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_sesion", nullable = false, columnDefinition = "text")
    var tipoSesion: TipoSesion = TipoSesion.Clase
)
