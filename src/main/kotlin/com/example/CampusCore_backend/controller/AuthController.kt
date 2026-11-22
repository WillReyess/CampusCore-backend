package com.example.CampusCore_backend.controller

import com.example.CampusCore_backend.dto.AuthResponse
import com.example.CampusCore_backend.dto.LoginRequest
import com.example.CampusCore_backend.security.JwtService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController( 
    private val authenticationManager: AuthenticationManager,
    private val userDetailsService: UserDetailsService,
    private val jwtService: JwtService
) {

    @PostMapping("/login")
    fun login(@Valid @RequestBody request: LoginRequest): ResponseEntity<AuthResponse> {
        val correo = request.correo.trim().lowercase()

        // valida credenciales (Spring usa CustomUserDetailsService + PasswordEncoder)
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(correo, request.password)
        )

        // carga  datos del usuario
        val userDetails = userDetailsService.loadUserByUsername(correo)

        // genera token JWT
        val token = jwtService.generateToken(userDetails)
        val roles = userDetails.authorities.map { it.authority }

        return ResponseEntity.ok(
            AuthResponse(
                token = token,
                correo = userDetails.username,
                roles = roles
            )
        )
    }
}
