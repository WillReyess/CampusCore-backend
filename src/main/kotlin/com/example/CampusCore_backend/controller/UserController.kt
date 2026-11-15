package com.example.CampusCore_backend.controller

import com.example.CampusCore_backend.dto.RegisterRequest
import com.example.CampusCore_backend.dto.UpdateUserRequest
import com.example.CampusCore_backend.dto.UserResponse
import com.example.CampusCore_backend.service.UserService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
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
    fun create(@Valid @RequestBody request: RegisterRequest): ResponseEntity<UserResponse> {
        val user = userService.register(request)
        return ResponseEntity.created(URI.create("/users/${user.id}")).body(user)
    }

    @GetMapping
    fun findAll(): List<UserResponse> = userService.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): UserResponse = userService.findById(id)

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @Valid @RequestBody request: UpdateUserRequest
    ): UserResponse = userService.update(id, request)
}
