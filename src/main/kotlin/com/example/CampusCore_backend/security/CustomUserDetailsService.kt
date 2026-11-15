package com.example.CampusCore_backend.security

import com.example.CampusCore_backend.repository.UserRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val correo = username.trim().lowercase()
        val user = userRepository.findByCorreo(correo)
            ?: throw UsernameNotFoundException("Credenciales inválidas")

        return User.withUsername(user.correo)
            .password(user.passwordHash)
            .authorities("ROLE_${user.rol}")
            .disabled(!user.activo)
            .build()
    }
}
