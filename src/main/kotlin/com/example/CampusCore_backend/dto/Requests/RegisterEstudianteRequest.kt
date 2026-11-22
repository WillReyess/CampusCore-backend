package com.example.CampusCore_backend.dto.Requests

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class RegisterEstudianteRequest(
    @field:NotBlank(message = "El nombre es obligatorio")
    val nombres: String,

    @field:NotBlank(message = "El apellido es obligatorio")
    val apellidos: String,

    val documentoIdentidad: String = "",

    val telefono: String = "",

    @field:NotBlank(message = "El correo es obligatorio")
    @field:Email(message = "Formato de correo no válido")
    val correo: String,

    val fechaNacimiento: LocalDate? = null,

    val direccion: String = "",

    val contactoEmergencia: String = "",

    @field:NotBlank(message = "La contraseña es obligatoria")
    val password: String,

    @field:NotBlank(message = "El carnet es obligatorio")
    val carnet: String,

    @field:NotNull(message = "El ID de la carrera es obligatorio")
    val idCarrera: Long
)
