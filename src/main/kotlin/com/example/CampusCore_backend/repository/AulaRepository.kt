package com.example.CampusCore_backend.repository

import com.example.CampusCore_backend.entity.Aula
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AulaRepository : JpaRepository<Aula, Long> {
    fun findByIdEdificio(idEdificio: Long): List<Aula>
    fun findByIdEdificioAndCodigo(idEdificio: Long, codigo: String): Aula?
    fun existsByIdEdificioAndCodigo(idEdificio: Long, codigo: String): Boolean
}
