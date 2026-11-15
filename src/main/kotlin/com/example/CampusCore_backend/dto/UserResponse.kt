package com.example.CampusCore_backend.dto

import java.time.LocalDate
import java.time.OffsetDateTime

data class UserResponse(
    val id: Long,
    val correo: String,
    val nombres: String,
    val apellidos: String,
    val documentoIdentidad: String?,
    val telefono: String?,
    val direccion: String?,
    val fechaNacimiento: LocalDate?,
    val contactoEmergencia: String?,
    val roles: List<String>,
    val creadoEn: OffsetDateTime?
)
