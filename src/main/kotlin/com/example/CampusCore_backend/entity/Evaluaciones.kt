package com.example.CampusCore_backend.entity

import com.example.CampusCore_backend.entity.enums.ModalidadEvaluacion
import com.example.CampusCore_backend.entity.enums.TipoEvaluacion
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(name = "evaluaciones")
class Evaluacion(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "grupo_id", nullable = false)
    var idGrupo: Long = 0,

    @Column(name = "evaluacion_padre_id")
    var idEvaluacionPadre: Long? = null,

    @Column(nullable = false, columnDefinition = "text")
    var nombre: String = "",

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "text")
    var tipo: TipoEvaluacion = TipoEvaluacion.Parcial,

    @Column(nullable = false, precision = 5, scale = 2)
    var porcentaje: BigDecimal = BigDecimal.ZERO,

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "text")
    var modalidad: ModalidadEvaluacion? = ModalidadEvaluacion.Individual,

    @Column(name = "porcentaje_grupal", precision = 5, scale = 2)
    var porcentajeGrupal: BigDecimal? = null,

    @Column(name = "porcentaje_individual", precision = 5, scale = 2)
    var porcentajeIndividual: BigDecimal? = null,

    var fecha: LocalDate? = null
)
