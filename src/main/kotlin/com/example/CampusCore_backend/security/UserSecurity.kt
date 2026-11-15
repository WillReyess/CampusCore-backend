package com.example.CampusCore_backend.security

import com.example.CampusCore_backend.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component("userSecurity")
class UserSecurity(
    private val userRepository: UserRepository
) {

    fun isSelf(id: Long): Boolean {
        val authentication = SecurityContextHolder.getContext().authentication ?: return false
        if (!authentication.isAuthenticated) return false

        val user = userRepository.findByIdOrNull(id) ?: return false
        return user.correo == authentication.name
    }
}
