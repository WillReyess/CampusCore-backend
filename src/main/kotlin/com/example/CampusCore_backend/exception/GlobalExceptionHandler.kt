package com.example.CampusCore_backend.exception

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.AccessDeniedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

data class ApiError(
    val message: String,
    val details: List<String> = emptyList()
)

@RestControllerAdvice
class GlobalExceptionHandler {

    private val logger = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidation(ex: MethodArgumentNotValidException): ResponseEntity<ApiError> {
        val details = ex.bindingResult.fieldErrors.map { "${it.field}: ${it.defaultMessage}" }
        return ResponseEntity.badRequest().body(ApiError("Solicitud inválida", details))
    }

    @ExceptionHandler(ConflictException::class)
    fun handleConflict(ex: ConflictException): ResponseEntity<ApiError> =
        ResponseEntity.status(HttpStatus.CONFLICT)
            .body(ApiError(ex.message ?: "Conflicto"))

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(ex: NoSuchElementException): ResponseEntity<ApiError> =
        ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(ApiError(ex.message ?: "Recurso no encontrado"))

    @ExceptionHandler(AccessDeniedException::class)
    fun handleForbidden(ex: AccessDeniedException): ResponseEntity<ApiError> =
        ResponseEntity.status(HttpStatus.FORBIDDEN)
            .body(ApiError("No autorizado"))

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(ex: IllegalArgumentException): ResponseEntity<ApiError> =
        ResponseEntity.badRequest().body(ApiError(ex.message ?: "Solicitud inválida"))

    @ExceptionHandler(Exception::class)
    fun handleGeneric(ex: Exception): ResponseEntity<ApiError> {
        logger.error("Error no controlado", ex)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ApiError("Error interno del servidor"))
    }
}
