package com.senai.carteirinha_will.feature.professor.turmas.data.remote.dto

import com.senai.carteirinha_will.feature.aluno.unidadescurriculares.domain.model.UnidadeCurricular
import com.senai.carteirinha_will.feature.professor.turmas.domain.model.TurmasProfessor
import kotlinx.serialization.Serializable

@Serializable
data class TurmasProfessorDTO(
    val id: String,
    val nome: String,
    val curso: String,
    val quantidadeAlunos: Int,
    val horario: String,
    val semestre: String,
    val diasSemana: List<String>,
    val horarioInicio: String,
    val horarioFim: String
) {
    fun toDomain(): TurmasProfessor {
        return TurmasProfessor(
            id = id,
            nome = nome,
            curso = curso,
            quantidadeAlunos = quantidadeAlunos,
            horario = horario,
            semestre = semestre,
            diasSemana = diasSemana,
            horarioInicio = horarioInicio,
            horarioFim = horarioFim
        )
    }
}