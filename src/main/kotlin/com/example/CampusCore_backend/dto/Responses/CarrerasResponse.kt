package com.example.CampusCore_backend.dto.Responses

data class CarrerasResponse(
    val id: Long,
    val nombre: String,
    val codigo: String?,
    val idFacultad: Long
)