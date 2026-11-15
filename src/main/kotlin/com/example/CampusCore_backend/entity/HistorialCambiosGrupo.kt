package com.example.CampusCore_backend.entity

import jakarta.persistence.*
import java.time.OffsetDateTime

@Entity
@Table(name = "historial_cambios_grupo")
class HistorialCambioGrupo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "estudiante_id", nullable = false)
    var idEstudiante: Long = 0,

    @Column(name = "grupo_origen_id", nullable = false)
    var idGrupoOrigen: Long = 0,

    @Column(name = "grupo_destino_id", nullable = false)
    var idGrupoDestino: Long = 0,

    @Column(name = "realizado_por_usuario_id", nullable = false)
    var idRealizadoPorUsuario: Long = 0,

    @Column(columnDefinition = "text")
    var motivo: String? = null,

    @Column(name = "fecha_cambio")
    var fechaCambio: OffsetDateTime? = null
)
