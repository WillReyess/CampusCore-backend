package com.example.CampusCore_backend.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "pensum_materias")
class PensumMateria(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "materia_id", nullable = false)
    var idMateria: Long = 0,

    @Column(name = "anio_pensum", nullable = false)
    var anioPensum: Int = 0,

    @Column(nullable = false)
    var creditos: Int = 0,

    @Column(name = "nota_minima_aprobacion", nullable = false, precision = 4, scale = 2)
    var notaMinimaAprobacion: BigDecimal = BigDecimal("6.00")
)
