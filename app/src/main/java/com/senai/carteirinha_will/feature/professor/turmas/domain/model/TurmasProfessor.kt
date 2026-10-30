package com.senai.carteirinha_will.feature.professor.turmas.domain.model

data class TurmasProfessor(
    val id: String,
    val nome: String,
    val curso: String,
    val quantidadeAlunos: Int,
    val horario: String,
    val semestre: String,
    val diasSemana: List<String>,
    val horarioInicio: String,
    val horarioFim: String
)