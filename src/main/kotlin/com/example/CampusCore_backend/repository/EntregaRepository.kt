package com.example.CampusCore_backend.repository

import com.example.CampusCore_backend.entity.Entrega
import com.example.CampusCore_backend.entity.enums.EstadoEntrega
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EntregaRepository : JpaRepository<Entrega, Long> {
    fun findByIdTarea(idTarea: Long): List<Entrega>
    fun findByIdEstudiante(idEstudiante: Long): List<Entrega>
    fun findByIdTareaAndIdEstudiante(idTarea: Long, idEstudiante: Long): Entrega?
    fun findByIdTareaAndEstado(idTarea: Long, estado: EstadoEntrega): List<Entrega>
    fun existsByIdTareaAndIdEstudiante(idTarea: Long, idEstudiante: Long): Boolean
}
