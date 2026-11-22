package com.example.CampusCore_backend.controller

import com.example.CampusCore_backend.dto.Requests.LoginRequest
import com.example.CampusCore_backend.dto.Responses.AuthResponde
import com.example.CampusCore_backend.repository.UserRepository
import com.example.CampusCore_backend.security.JwtService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authenticationManager: AuthenticationManager,
    private val jwtService: JwtService,
    private val userRepository: UserRepository
) {

    @PostMapping("/login")
    fun login(@Valid @RequestBody request: LoginRequest): ResponseEntity<AuthResponde> {
        val correo = request.correo.trim().lowercase()
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(correo, request.password)
        )

        val user = userRepository.findByCorreo(correo)
            ?: throw IllegalArgumentException("Usuario no encontrado")

        val token = jwtService.generateToken(
            org.springframework.security.core.userdetails.User.withUsername(user.correo)
                .password(user.passwordHash)
                .authorities(user.roles.map { org.springframework.security.core.authority.SimpleGrantedAuthority("ROLE_${it.nombre}") })
                .build()
        )

        return ResponseEntity.ok(
            AuthResponde(
                token = token,
                refreshToken = "",
                correo = user.correo,
                idUsuario = user.id,
                roles = user.roles.map { it.nombre }
            )
        )
    }
}
