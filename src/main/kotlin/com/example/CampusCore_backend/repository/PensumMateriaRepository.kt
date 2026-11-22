package com.example.CampusCore_backend.repository

import com.example.CampusCore_backend.entity.PensumMateria
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PensumMateriaRepository : JpaRepository<PensumMateria, Long> {
    fun findByIdMateria(idMateria: Long): List<PensumMateria>
    fun findByAnioPensum(anioPensum: Int): List<PensumMateria>
}
