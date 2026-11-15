package com.example.CampusCore_backend.entity

import com.example.CampusCore_backend.entity.enums.EstadoProfesor
import jakarta.persistence.*

@Entity
@Table(
    name = "profesores",
    uniqueConstraints = [UniqueConstraint(name = "profesores_usuario_id_key", columnNames = ["usuario_id"])]
)
class Profesor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "usuario_id", nullable = false)
    var idUsuario: Long = 0,

    @Column(name = "facultad_id", nullable = false)
    var idFacultad: Long = 0,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "text")
    var estado: EstadoProfesor = EstadoProfesor.Activo
)
