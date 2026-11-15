package com.example.CampusCore_backend.entity

import jakarta.persistence.*

@Entity
@Table(
    name = "materias",
    uniqueConstraints = [UniqueConstraint(name = "materias_codigo_key", columnNames = ["codigo"])]
)
class Materia(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, length = 50)
    var codigo: String = "",

    @Column(nullable = false, length = 150)
    var nombre: String = "",

    @Column(columnDefinition = "text")
    var descripcion: String? = null
)
