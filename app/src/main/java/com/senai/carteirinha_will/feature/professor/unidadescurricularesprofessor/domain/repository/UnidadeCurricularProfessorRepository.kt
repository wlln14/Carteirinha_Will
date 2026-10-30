package com.senai.carteirinha_will.feature.professor.unidadescurricularesprofessor.domain.repository

import com.senai.carteirinha_will.feature.professor.unidadescurricularesprofessor.domain.model.UnidadeCurricularProfessor

interface UnidadeCurricularProfessorRepository {
    suspend fun listar():Result<List<UnidadeCurricularProfessor>>
}