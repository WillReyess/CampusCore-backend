package com.example.CampusCore_backend.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Size
import java.time.LocalDate

data class UpdateUserRequest(
    @field:NotBlank(message = "Los nombres no pueden estar vacíos")
    @field:Size(max = 100, message = "Los nombres no pueden superar los 100 caracteres")
    val nombres: String? = null,

    @field:NotBlank(message = "Los apellidos no pueden estar vacíos")
    @field:Size(max = 100, message = "Los apellidos no pueden superar los 100 caracteres")
    val apellidos: String? = null,

    @field:Size(max = 30, message = "El teléfono no puede superar los 30 caracteres")
    val telefono: String? = null,

    @field:Size(max = 255, message = "La dirección no puede superar los 255 caracteres")
    val direccion: String? = null,

    @field:Past(message = "La fecha de nacimiento debe ser anterior a hoy")
    val fechaNacimiento: LocalDate? = null,

    @field:Size(max = 255, message = "El contacto de emergencia no puede superar los 255 caracteres")
    val contactoEmergencia: String? = null
)
