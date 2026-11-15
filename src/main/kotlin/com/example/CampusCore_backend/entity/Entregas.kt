package com.example.CampusCore_backend.entity

import com.example.CampusCore_backend.entity.enums.EstadoEntrega
import jakarta.persistence.*
import java.time.OffsetDateTime

@Entity
@Table(
    name = "entregas",
    uniqueConstraints = [
        UniqueConstraint(
            name = "entregas_tarea_id_estudiante_id_key",
            columnNames = ["tarea_id", "estudiante_id"]
        )
    ]
)
class Entrega(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "tarea_id", nullable = false)
    var idTarea: Long = 0,

    @Column(name = "estudiante_id", nullable = false)
    var idEstudiante: Long = 0,

    @Column(name = "archivo_url", columnDefinition = "text")
    var archivoUrl: String? = null,

    @Column(name = "fecha_entrega")
    var fechaEntrega: OffsetDateTime? = null,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "text")
    var estado: EstadoEntrega = EstadoEntrega.Pendiente,

    @Column(columnDefinition = "text")
    var observaciones: String? = null
)
