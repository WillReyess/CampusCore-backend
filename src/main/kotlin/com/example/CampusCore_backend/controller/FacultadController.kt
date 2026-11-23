package com.example.CampusCore_backend.controller

import com.example.CampusCore_backend.dto.Requests.FacultadesRequest
import com.example.CampusCore_backend.dto.Responses.FacultadesResponse
import com.example.CampusCore_backend.service.FacultadService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/api/facultades")
class FacultadController(
    private val facultadService: FacultadService
) {

    @GetMapping
    fun listar(): ResponseEntity<List<FacultadesResponse>> =
        ResponseEntity.ok(facultadService.listar())

    @GetMapping("/{id}")
    fun obtener(@PathVariable id: Long): ResponseEntity<FacultadesResponse> =
        ResponseEntity.ok(facultadService.obtenerPorId(id))

    @PostMapping
    fun crear(@Valid @RequestBody request: FacultadesRequest): ResponseEntity<FacultadesResponse> {
        val response = facultadService.crear(request)
        return ResponseEntity.created(URI.create("/api/facultades/${response.id}")).body(response)
    }

    @PutMapping("/{id}")
    fun actualizar(@PathVariable id: Long, @Valid @RequestBody request: FacultadesRequest): ResponseEntity<FacultadesResponse> =
        ResponseEntity.ok(facultadService.actualizar(id, request))

    @DeleteMapping("/{id}")
    fun eliminar(@PathVariable id: Long): ResponseEntity<Void> {
        facultadService.eliminar(id)
        return ResponseEntity.noContent().build()
    }
}