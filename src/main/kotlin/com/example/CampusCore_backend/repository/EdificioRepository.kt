package com.example.CampusCore_backend.repository

import com.example.CampusCore_backend.entity.Edificio
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EdificioRepository : JpaRepository<Edificio, Long> {
    fun findByCodigo(codigo: String): Edificio?
    fun existsByCodigo(codigo: String): Boolean
}
