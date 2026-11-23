package com.example.CampusCore_backend.dto.Requests

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class CarrerasRequest(
    @field:NotBlank(message = "El nombre es obligatorio")
    @field:Size(max = 150, message = "El nombre no puede superar 150 caracteres")
    val nombre: String,

    @field:Size(max = 50, message = "El código no puede superar 50 caracteres")
    val codigo: String? = null,

    @field:NotNull(message = "El ID de la facultad es obligatorio")
    val idFacultad: Long
)