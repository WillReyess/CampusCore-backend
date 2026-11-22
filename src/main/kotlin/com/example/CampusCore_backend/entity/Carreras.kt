package com.example.CampusCore_backend.entity

import jakarta.persistence.*

@Entity
@Table(
    name = "carreras",
    uniqueConstraints = [UniqueConstraint(name = "carreras_codigo_key", columnNames = ["codigo"])]
)
class Carrera(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(nullable = false, length = 150)
    var nombre: String = "",

    @Column(length = 50)
    var codigo: String? = null,

    @Column(name = "facultad_id", nullable = false)
    var idFacultad: Long = 0
)
