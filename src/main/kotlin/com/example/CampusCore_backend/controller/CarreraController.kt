package com.example.CampusCore_backend.controller

import com.example.CampusCore_backend.dto.Requests.CarrerasRequest
import com.example.CampusCore_backend.dto.Responses.CarrerasResponse
import com.example.CampusCore_backend.service.CarreraService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/api/carreras")
class CarreraController(
    private val carreraService: CarreraService
) {

    @GetMapping
    fun listar(@RequestParam(required = false) idFacultad: Long?): ResponseEntity<List<CarrerasResponse>> =
        ResponseEntity.ok(
            if (idFacultad != null) carreraService.listarPorFacultad(idFacultad) else carreraService.listar()
        )

    @GetMapping("/{id}")
    fun obtener(@PathVariable id: Long): ResponseEntity<CarrerasResponse> =
        ResponseEntity.ok(carreraService.obtenerPorId(id))

    @PostMapping
    fun crear(@Valid @RequestBody request: CarrerasRequest): ResponseEntity<CarrerasResponse> {
        val response = carreraService.crear(request)
        return ResponseEntity.created(URI.create("/api/carreras/${response.id}")).body(response)
    }

    @PutMapping("/{id}")
    fun actualizar(@PathVariable id: Long, @Valid @RequestBody request: CarrerasRequest): ResponseEntity<CarrerasResponse> =
        ResponseEntity.ok(carreraService.actualizar(id, request))

    @DeleteMapping("/{id}")
    fun eliminar(@PathVariable id: Long): ResponseEntity<Void> {
        carreraService.eliminar(id)
        return ResponseEntity.noContent().build()
    }
}