package com.example.CampusCore_backend.entity

import com.example.CampusCore_backend.entity.enums.EstadoPeriodo
import com.example.CampusCore_backend.entity.enums.TipoPeriodo
import jakarta.persistence.*
import java.time.LocalDate
import java.time.OffsetDateTime

@Entity
@Table(
    name = "periodos_academicos",
    uniqueConstraints = [
        UniqueConstraint(
            name = "periodos_academicos_anio_numero_tipo_key",
            columnNames = ["anio", "numero", "tipo"]
        )
    ]
)
class PeriodoAcademico(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var anio: Int = 0,

    @Column(nullable = false)
    var numero: Int = 0,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    var tipo: TipoPeriodo = TipoPeriodo.Semestre,

    @Column(name = "fecha_inicio", nullable = false)
    var fechaInicio: LocalDate = LocalDate.now(),

    @Column(name = "fecha_fin", nullable = false)
    var fechaFin: LocalDate = LocalDate.now(),

    @Column(name = "inicio_matricula", nullable = false)
    var inicioMatricula: LocalDate = LocalDate.now(),

    @Column(name = "fin_matricula", nullable = false)
    var finMatricula: LocalDate = LocalDate.now(),

    @Column(name = "cierre_notas", nullable = false)
    var cierreNotas: OffsetDateTime = OffsetDateTime.now(),

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "text")
    var estado: EstadoPeriodo = EstadoPeriodo.Planificado
)
