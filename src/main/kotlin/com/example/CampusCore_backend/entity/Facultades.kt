package com.example.CampusCore_backend.entity

import jakarta.persistence.*

@Entity
@Table(
    name = "facultades",
    uniqueConstraints = [
        UniqueConstraint(name = "facultades_codigo_key", columnNames = ["codigo"]),
        UniqueConstraint(name = "facultades_nombre_key", columnNames = ["nombre"])
    ]
)
class Facultad(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, length = 150)
    var nombre: String = "",

    @Column(length = 50)
    var codigo: String? = null
)
