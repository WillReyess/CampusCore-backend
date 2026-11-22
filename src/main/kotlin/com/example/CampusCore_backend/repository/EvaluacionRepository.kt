package com.example.CampusCore_backend.repository

import com.example.CampusCore_backend.entity.Evaluacion
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EvaluacionRepository : JpaRepository<Evaluacion, Long> {
    fun findByIdGrupo(idGrupo: Long): List<Evaluacion>
    fun findByIdEvaluacionPadre(idEvaluacionPadre: Long): List<Evaluacion>
}
