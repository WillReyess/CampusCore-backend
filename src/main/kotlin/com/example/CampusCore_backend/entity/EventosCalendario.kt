package com.example.CampusCore_backend.entity

import com.example.CampusCore_backend.entity.enums.TipoEvento
import jakarta.persistence.*
import java.time.OffsetDateTime

@Entity
@Table(name = "eventos_calendario")
class EventoCalendario(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "usuario_id")
    var idUsuario: Long? = null,

    @Column(name = "grupo_id")
    var idGrupo: Long? = null,

    @Column(nullable = false, columnDefinition = "text")
    var titulo: String = "",

    @Column(columnDefinition = "text")
    var descripcion: String? = null,

    @Column(name = "fecha_inicio", nullable = false)
    var fechaInicio: OffsetDateTime = OffsetDateTime.now(),

    @Column(name = "fecha_fin", nullable = false)
    var fechaFin: OffsetDateTime = OffsetDateTime.now(),

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento", nullable = false, columnDefinition = "text")
    var tipoEvento: TipoEvento = TipoEvento.Personal
)
