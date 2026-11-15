package com.example.CampusCore_backend.entity

import jakarta.persistence.*

@Entity
@Table(
    name = "aulas",
    uniqueConstraints = [UniqueConstraint(name = "aulas_edificio_id_codigo_key", columnNames = ["edificio_id", "codigo"])]
)
class Aula(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "edificio_id", nullable = false)
    var idEdificio: Long = 0,

    @Column(nullable = false, length = 50)
    var codigo: String = "",

    @Column(nullable = false)
    var capacidad: Int = 0
)
