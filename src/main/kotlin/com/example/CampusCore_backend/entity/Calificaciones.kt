package com.example.CampusCore_backend.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(
    name = "calificaciones",
    uniqueConstraints = [
        UniqueConstraint(
            name = "calificaciones_evaluacion_id_estudiante_id_key",
            columnNames = ["evaluacion_id", "estudiante_id"]
        )
    ]
)
class Calificacion(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "evaluacion_id", nullable = false)
    var idEvaluacion: Long = 0,

    @Column(name = "estudiante_id", nullable = false)
    var idEstudiante: Long = 0,

    @Column(precision = 4, scale = 2)
    var nota: BigDecimal? = null,

    @Column(columnDefinition = "text")
    var observacion: String? = null
)
