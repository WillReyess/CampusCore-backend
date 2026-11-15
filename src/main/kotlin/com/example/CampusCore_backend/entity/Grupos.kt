package com.example.CampusCore_backend.entity

import jakarta.persistence.*

@Entity
@Table(
    name = "grupos",
    uniqueConstraints = [
        UniqueConstraint(
            name = "grupos_periodo_id_materia_id_nombre_grupo_key",
            columnNames = ["periodo_id", "materia_id", "nombre_grupo"]
        )
    ]
)
class Grupo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "periodo_id", nullable = false)
    var idPeriodo: Long = 0,

    @Column(name = "materia_id", nullable = false)
    var idMateria: Long = 0,

    @Column(name = "profesor_id", nullable = false)
    var idProfesor: Long = 0,

    @Column(name = "nombre_grupo", nullable = false, length = 100)
    var nombreGrupo: String = "",

    @Column(nullable = false)
    var capacidad: Int = 0
)
