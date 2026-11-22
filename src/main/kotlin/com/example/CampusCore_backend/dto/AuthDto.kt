package com.example.CampusCore_backend.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class LoginRequest(
    @field:NotBlank(message = "El correo es requerido")
    @field:Email(message = "Formato de correo inválido")
    val correo: String,

    @field:NotBlank(message = "La contraseña es requerida")
    val password: String
)

data class AuthResponse(
    val token: String,
    val tipo: String = "Bearer",
    val correo: String,
    val roles: List<String>
)
