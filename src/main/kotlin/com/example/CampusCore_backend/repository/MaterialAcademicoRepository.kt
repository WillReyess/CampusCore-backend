package com.example.CampusCore_backend.repository

import com.example.CampusCore_backend.entity.MaterialAcademico
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MaterialAcademicoRepository : JpaRepository<MaterialAcademico, Long> {
    fun findByIdGrupo(idGrupo: Long): List<MaterialAcademico>
    fun findByIdTarea(idTarea: Long): List<MaterialAcademico>
}
