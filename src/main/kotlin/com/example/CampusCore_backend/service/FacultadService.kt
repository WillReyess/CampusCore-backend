package com.example.CampusCore_backend.service

import com.example.CampusCore_backend.dto.Requests.FacultadesRequest
import com.example.CampusCore_backend.dto.Responses.FacultadesResponse
import com.example.CampusCore_backend.entity.Facultad
import com.example.CampusCore_backend.repository.FacultadRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.NoSuchElementException

@Service
class FacultadService(
    private val facultadRepository: FacultadRepository
) {

    @Transactional(readOnly = true)
    fun listar(): List<FacultadesResponse> =
        facultadRepository.findAll().map { it.toResponse() }

    @Transactional(readOnly = true)
    fun obtenerPorId(id: Long): FacultadesResponse =
        facultadRepository.findByIdOrNull(id)?.toResponse()
            ?: throw NoSuchElementException("Facultad no encontrada")

    @Transactional
    fun crear(request: FacultadesRequest): FacultadesResponse {
        val facultad = Facultad(
            nombre = request.nombre.trim(),
            codigo = request.codigo?.trim()?.takeIf { it.isNotEmpty() }
        )
        return facultadRepository.save(facultad).toResponse()
    }

    @Transactional
    fun actualizar(id: Long, request: FacultadesRequest): FacultadesResponse {
        val existente = facultadRepository.findByIdOrNull(id)
            ?: throw NoSuchElementException("Facultad no encontrada")
        existente.nombre = request.nombre.trim()
        existente.codigo = request.codigo?.trim()?.takeIf { it.isNotEmpty() }
        return facultadRepository.save(existente).toResponse()
    }

    @Transactional
    fun eliminar(id: Long) {
        if (!facultadRepository.existsById(id)) {
            throw NoSuchElementException("Facultad no encontrada")
        }
        facultadRepository.deleteById(id)
    }

    private fun Facultad.toResponse() = FacultadesResponse(
        id = this.id!!,
        nombre = this.nombre,
        codigo = this.codigo
    )
}