package com.example.CampusCore_backend.entity

import jakarta.persistence.*
import java.time.LocalDate
import java.time.OffsetDateTime

@Entity
@Table(name = "usuarios")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, unique = true, length = 255)
    var correo: String = "",

    @Column(name = "password_hash", nullable = false, length = 100)
    var passwordHash: String = "",

    @Column(nullable = false, length = 100)
    var nombres: String = "",

    @Column(nullable = false, length = 100)
    var apellidos: String = "",

    @Column(name = "documento_identidad", unique = true, length = 50)
    var documentoIdentidad: String? = null,

    @Column(length = 30)
    var telefono: String? = null,

    @Column(length = 255)
    var direccion: String? = null,

    @Column(name = "fecha_nacimiento")
    var fechaNacimiento: LocalDate? = null,

    @Column(name = "contacto_emergencia", length = 255)
    var contactoEmergencia: String? = null,

    // Opcionales recomendados:
    @Column(nullable = false, length = 20)
    var rol: String = "ESTUDIANTE",

    @Column(nullable = false)
    var activo: Boolean = true,

    @Column(name = "creado_en", updatable = false)
    var creadoEn: OffsetDateTime? = null
) {
    @PrePersist
    fun prePersist() {
        if (creadoEn == null) {
            creadoEn = OffsetDateTime.now()
        }
    }
}