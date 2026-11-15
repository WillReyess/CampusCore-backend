package com.example.CampusCore_backend.entity

import com.example.CampusCore_backend.entity.enums.CategoriaTarea
import com.example.CampusCore_backend.entity.enums.PrioridadTarea
import jakarta.persistence.*
import java.time.OffsetDateTime

@Entity
@Table(name = "tareas")
class Tarea(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "grupo_id", nullable = false)
    var idGrupo: Long = 0,

    @Column(nullable = false, columnDefinition = "text")
    var titulo: String = "",

    @Column(columnDefinition = "text")
    var descripcion: String? = null,

    @Column(name = "fecha_asignacion")
    var fechaAsignacion: OffsetDateTime? = null,

    @Column(name = "fecha_entrega", nullable = false)
    var fechaEntrega: OffsetDateTime = OffsetDateTime.now(),

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "text")
    var categoria: CategoriaTarea = CategoriaTarea.`Tarea no calificable`,

    @Enumerated(EnumType.STRING)
    @Column(name = "prioridad_calculada", columnDefinition = "text")
    var prioridadCalculada: PrioridadTarea? = PrioridadTarea.Media,

    @Column(name = "es_grupal")
    var esGrupal: Boolean = false
)
