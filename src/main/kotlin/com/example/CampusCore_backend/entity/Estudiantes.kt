package com.example.CampusCore_backend.entity

import com.example.CampusCore_backend.entity.enums.EstadoEstudiante
import jakarta.persistence.*

@Entity
@Table(name = "estudiantes")
class Estudiante(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "usuario_id", nullable = false, unique = true)
    var idUsuario: Long = 0,

    @Column(nullable = false, unique = true, length = 50)
    var carnet: String = "",

    @Column(name = "carrera_id", nullable = false)
    var idCarrera: Long = 0,

    @Column(name = "nivel_actual", length = 50)
    var nivelActual: String? = null,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "text")
    var estado: EstadoEstudiante = EstadoEstudiante.Activo
)
