package com.example.CampusCore_backend.entity

import jakarta.persistence.*
import java.io.Serializable

data class GrupoTrabajoEstudianteId(
    var idTarea: Long = 0,
    var idEstudiante: Long = 0
) : Serializable

@Entity
@Table(name = "grupos_trabajo_estudiantes")
@IdClass(GrupoTrabajoEstudianteId::class)
class GrupoTrabajoEstudiante(
    @Id
    @Column(name = "tarea_id", nullable = false)
    var idTarea: Long = 0,

    @Id
    @Column(name = "estudiante_id", nullable = false)
    var idEstudiante: Long = 0
)
