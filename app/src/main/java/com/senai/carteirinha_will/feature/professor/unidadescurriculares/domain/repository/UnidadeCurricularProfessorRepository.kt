package com.senai.carteirinha_will.feature.professor.unidadescurriculares.domain.repository

import com.senai.carteirinha_will.feature.professor.unidadescurriculares.domain.model.UnidadeCurricularProfessor

interface UnidadeCurricularProfessorRepository {
    suspend fun listar():Result<List<UnidadeCurricularProfessor>>
}