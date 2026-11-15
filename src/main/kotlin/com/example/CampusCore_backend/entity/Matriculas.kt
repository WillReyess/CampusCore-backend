package com.example.CampusCore_backend.entity

import com.example.CampusCore_backend.entity.enums.EstadoMatricula
import jakarta.persistence.*
import java.time.OffsetDateTime

@Entity
@Table(
    name = "matriculas",
    uniqueConstraints = [
        UniqueConstraint(
            name = "matriculas_estudiante_id_grupo_id_key",
            columnNames = ["estudiante_id", "grupo_id"]
        )
    ]
)
class Matricula(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "estudiante_id", nullable = false)
    var idEstudiante: Long = 0,

    @Column(name = "grupo_id", nullable = false)
    var idGrupo: Long = 0,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "text")
    var estado: EstadoMatricula = EstadoMatricula.Activa,

    @Column(name = "fecha_matricula")
    var fechaMatricula: OffsetDateTime? = null
)
