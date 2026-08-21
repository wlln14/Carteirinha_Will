package com.senai.carteirinha_will.unidadecurriculares.Domain.model

data class TurmasProfessor(
    val id: String,
    val nome: String,
    val curso: String,
    val quantidadeAlunos: Int,
    val horario: String,
    val semestre: String
)