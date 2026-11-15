package com.example.CampusCore_backend.entity

import jakarta.persistence.*

@Entity
@Table(
    name = "roles",
    uniqueConstraints = [UniqueConstraint(name = "roles_nombre_key", columnNames = ["nombre"])]
)
class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, length = 100)
    var nombre: String = ""
)
