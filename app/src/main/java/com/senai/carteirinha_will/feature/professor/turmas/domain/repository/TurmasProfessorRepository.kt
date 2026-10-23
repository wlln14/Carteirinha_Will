package com.senai.carteirinha_will.feature.professor.turmas.domain.repository

import com.senai.carteirinha_will.feature.professor.turmas.domain.model.TurmasProfessor

interface TurmasProfessorRepository {
    suspend fun listar():Result<List<TurmasProfessor>>
}