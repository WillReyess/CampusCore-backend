package com.example.CampusCore_backend.dto.Responses

data class SideBarResponse(
    val usuarioId: Long,
    val nombreCompleto: String,
    val correo: String,
    val rol: String,
    val carnet: String? = null,
    val carrera: String? = null
)
