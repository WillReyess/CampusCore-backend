package com.example.CampusCore_backend.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Size
import java.time.LocalDate

data class RegisterRequest(
    @field:Email(message = "El correo no tiene un formato válido")
    @field:NotBlank(message = "El correo es obligatorio")
    @field:Size(max = 255, message = "El correo no puede superar los 255 caracteres")
    val correo: String = "",

    @field:NotBlank(message = "La contraseña es obligatoria")
    @field:Size(min = 8, max = 100, message = "La contraseña debe tener entre 8 y 100 caracteres")
    val password: String = "",

    @field:NotBlank(message = "Los nombres son obligatorios")
    @field:Size(max = 100, message = "Los nombres no pueden superar los 100 caracteres")
    val nombres: String = "",

    @field:NotBlank(message = "Los apellidos son obligatorios")
    @field:Size(max = 100, message = "Los apellidos no pueden superar los 100 caracteres")
    val apellidos: String = "",

    @field:Size(max = 50, message = "El documento no puede superar los 50 caracteres")
    val documentoIdentidad: String? = null,

    @field:Size(max = 30, message = "El teléfono no puede superar los 30 caracteres")
    val telefono: String? = null,

    @field:Size(max = 255, message = "La dirección no puede superar los 255 caracteres")
    val direccion: String? = null,

    @field:Past(message = "La fecha de nacimiento debe ser anterior a hoy")
    val fechaNacimiento: LocalDate? = null,

    @field:Size(max = 255, message = "El contacto de emergencia no puede superar los 255 caracteres")
    val contactoEmergencia: String? = null
)
