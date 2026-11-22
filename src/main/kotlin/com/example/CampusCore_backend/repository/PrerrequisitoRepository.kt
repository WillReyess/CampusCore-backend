package com.example.CampusCore_backend.repository

import com.example.CampusCore_backend.entity.Prerrequisito
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PrerrequisitoRepository : JpaRepository<Prerrequisito, Long> {
    fun findByIdMateriaPrerrequisito(idMateriaPrerrequisito: Long): List<Prerrequisito>
}
