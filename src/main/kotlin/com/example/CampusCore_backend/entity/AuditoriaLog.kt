package com.example.CampusCore_backend.entity

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.time.OffsetDateTime

@Entity
@Table(name = "auditoria_log")
class AuditoriaLog(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "usuario_id")
    var idUsuario: Long? = null,

    @Column(nullable = false, columnDefinition = "text")
    var operacion: String = "",

    @Column(name = "entidad_afectada", nullable = false, columnDefinition = "text")
    var entidadAfectada: String = "",

    @Column(name = "entidad_id")
    var idEntidad: Long? = null,

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "valor_anterior", columnDefinition = "json")
    var valorAnterior: String? = null,

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "valor_nuevo", columnDefinition = "json")
    var valorNuevo: String? = null,

    @Column
    var fecha: OffsetDateTime? = null
)
