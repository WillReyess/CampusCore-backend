package com.example.CampusCore_backend.dto.Responses

data class AuthResponde(
    val token: String,
    val tipo: String = "Bearer",
    val refreshToken: String,
    val correo: String,
    val idUsuario: Long,
    val roles: List<String>
)