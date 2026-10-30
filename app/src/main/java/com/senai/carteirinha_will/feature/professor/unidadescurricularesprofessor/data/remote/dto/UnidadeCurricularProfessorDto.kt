package com.senai.carteirinha_will.feature.professor.unidadescurricularesprofessor.data.remote.dto

import com.senai.carteirinha_will.feature.aluno.unidadescurriculares.domain.model.UnidadeCurricular
import com.senai.carteirinha_will.feature.professor.unidadescurricularesprofessor.domain.model.UnidadeCurricularProfessor
import kotlinx.serialization.Serializable

@Serializable
data class UnidadeCurricularProfessorDto(
    val id: Int,
    val nome: String,
    val turmaId: Int,
    val turma: String,
    val cargaHoraria: Int,
    val quantidadeAulas: Int,
    val aulasRealizadas: Int,
    val diasSemana: List<String>,
    val horarioInicio: String,
    val horarioFim: String
) {

    fun toDomain(): UnidadeCurricularProfessor {
        return UnidadeCurricularProfessor(
            id = id,
            nome = nome,
            turmaId = turmaId,
            turma = turma,
            cargaHoraria = cargaHoraria,
            quantidadeAulas = quantidadeAulas,
            aulasRealizadas = aulasRealizadas,
            diasSemana = diasSemana,
            horarioInicio = horarioInicio,
            horarioFim = horarioFim
        )
    }
}