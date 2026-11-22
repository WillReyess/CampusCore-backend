package com.example.CampusCore_backend.dto.Requests

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class LoginRequest(
    @field:NotBlank(message = "El correo es obligatorio")
    @field:Email(message = "El formato de correo no es válido")
    val correo: String,

    @field:NotBlank(message = "La contraseña es obligatoria")
    val password: String
)
