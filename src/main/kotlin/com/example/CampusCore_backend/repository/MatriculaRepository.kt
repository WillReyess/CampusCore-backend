package com.example.CampusCore_backend.repository

import com.example.CampusCore_backend.entity.Matricula
import com.example.CampusCore_backend.entity.enums.EstadoMatricula
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MatriculaRepository : JpaRepository<Matricula, Long> {
    fun findByIdEstudiante(idEstudiante: Long): List<Matricula>
    fun findByIdGrupo(idGrupo: Long): List<Matricula>
    fun findByIdEstudianteAndEstado(idEstudiante: Long, estado: EstadoMatricula): List<Matricula>
    fun existsByIdEstudianteAndIdGrupo(idEstudiante: Long, idGrupo: Long): Boolean
}
