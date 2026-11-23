package com.example.CampusCore_backend.service

import com.example.CampusCore_backend.dto.Requests.CarrerasRequest
import com.example.CampusCore_backend.dto.Responses.CarrerasResponse
import com.example.CampusCore_backend.entity.Carrera
import com.example.CampusCore_backend.repository.CarreraRepository
import com.example.CampusCore_backend.repository.FacultadRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.NoSuchElementException

@Service
class CarreraService(
    private val carreraRepository: CarreraRepository,
    private val facultadRepository: FacultadRepository
) {

    @Transactional(readOnly = true)
    fun listar(): List<CarrerasResponse> =
        carreraRepository.findAll().map { it.toResponse() }

    @Transactional(readOnly = true)
    fun listarPorFacultad(idFacultad: Long): List<CarrerasResponse> =
        carreraRepository.findByIdFacultad(idFacultad).map { it.toResponse() }

    @Transactional(readOnly = true)
    fun obtenerPorId(id: Long): CarrerasResponse =
        carreraRepository.findByIdOrNull(id)?.toResponse()
            ?: throw NoSuchElementException("Carrera no encontrada")

    @Transactional
    fun crear(request: CarrerasRequest): CarrerasResponse {
        if (facultadRepository.findByIdOrNull(request.idFacultad) == null) {
            throw NoSuchElementException("La facultad especificada no existe")
        }
        val carrera = Carrera(
            nombre = request.nombre.trim(),
            codigo = request.codigo?.trim()?.takeIf { it.isNotEmpty() },
            idFacultad = request.idFacultad
        )
        return carreraRepository.save(carrera).toResponse()
    }

    @Transactional
    fun actualizar(id: Long, request: CarrerasRequest): CarrerasResponse {
        val existente = carreraRepository.findByIdOrNull(id)
            ?: throw NoSuchElementException("Carrera no encontrada")
        if (facultadRepository.findByIdOrNull(request.idFacultad) == null) {
            throw NoSuchElementException("La facultad especificada no existe")
        }
        existente.nombre = request.nombre.trim()
        existente.codigo = request.codigo?.trim()?.takeIf { it.isNotEmpty() }
        existente.idFacultad = request.idFacultad
        return carreraRepository.save(existente).toResponse()
    }

    @Transactional
    fun eliminar(id: Long) {
        if (!carreraRepository.existsById(id)) {
            throw NoSuchElementException("Carrera no encontrada")
        }
        carreraRepository.deleteById(id)
    }

    private fun Carrera.toResponse() = CarrerasResponse(
        id = this.id,
        nombre = this.nombre,
        codigo = this.codigo,
        idFacultad = this.idFacultad
    )
}