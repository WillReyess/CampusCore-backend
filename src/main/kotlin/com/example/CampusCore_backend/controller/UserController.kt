package com.example.CampusCore_backend.controller

import com.example.CampusCore_backend.dto.Requests.RegisterEstudianteRequest
import com.example.CampusCore_backend.dto.Responses.SideBarResponse
import com.example.CampusCore_backend.service.UserService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    fun registrarEstudiante(
        @Valid @RequestBody request: RegisterEstudianteRequest
    ): ResponseEntity<SideBarResponse> {
        val response = userService.registrarEstudiante(request)
        return ResponseEntity.created(URI.create("/users/${response.usuarioId}")).body(response)
    }

    @GetMapping("/me")
    fun sideBar(@AuthenticationPrincipal principal: UserDetails): SideBarResponse =
        userService.getSideBar(principal.username)
}
