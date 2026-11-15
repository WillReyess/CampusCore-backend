package com.example.CampusCore_backend.entity

import jakarta.persistence.*

@Entity
@Table(name = "prerrequisitos")
class Prerrequisito(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "materia_prerrequisito_id", nullable = false)
    var idMateriaPrerrequisito: Long = 0
)
