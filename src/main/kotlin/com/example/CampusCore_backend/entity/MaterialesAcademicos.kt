package com.example.CampusCore_backend.entity

import jakarta.persistence.*

@Entity
@Table(name = "materiales_academicos")
class MaterialAcademico(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "grupo_id", nullable = false)
    var idGrupo: Long = 0,

    @Column(name = "tarea_id")
    var idTarea: Long? = null,

    @Column(nullable = false, columnDefinition = "text")
    var titulo: String = "",

    @Column(name = "archivo_url", nullable = false, columnDefinition = "text")
    var archivoUrl: String = "",

    @Column(columnDefinition = "text")
    var tipo: String? = null
)
