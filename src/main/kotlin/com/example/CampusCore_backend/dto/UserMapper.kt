package com.example.CampusCore_backend.dto

import com.example.CampusCore_backend.entity.User

fun User.toResponse(): UserResponse = UserResponse(
    id = requireNotNull(id) { "El usuario debe estar persistido para generar la respuesta" },
    correo = correo,
    nombres = nombres,
    apellidos = apellidos,
    documentoIdentidad = documentoIdentidad,
    telefono = telefono,
    direccion = direccion,
    fechaNacimiento = fechaNacimiento,
    contactoEmergencia = contactoEmergencia,
    roles = roles.map { it.nombre }.sorted(),
    creadoEn = creadoEn
)
