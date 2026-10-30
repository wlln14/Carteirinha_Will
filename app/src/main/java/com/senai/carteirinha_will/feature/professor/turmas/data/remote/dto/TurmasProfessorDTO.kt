package com.senai.carteirinha_will.feature.professor.turmas.data.remote.dto

import com.senai.carteirinha_will.feature.professor.turmas.domain.model.TurmasProfessor
import kotlinx.serialization.Serializable

@Serializable
data class TurmasProfessorDTO(
    val id: String,
    val codigo: String,
    val curso: String,
    val semestre: String,
    val quantidadeAlunos: Int,
    val diasSemana: List<String>,
    val horarioInicio: String,
    val horarioFim: String
) {
    fun toDomain(): TurmasProfessor {
        return TurmasProfessor(
            id = id,
            nome = codigo,
            curso = curso,
            quantidadeAlunos = quantidadeAlunos,
            horario = "$horarioInicio - $horarioFim",
            semestre = semestre,
            diasSemana = diasSemana,
            horarioInicio = horarioInicio,
            horarioFim = horarioFim
        )
    }
}