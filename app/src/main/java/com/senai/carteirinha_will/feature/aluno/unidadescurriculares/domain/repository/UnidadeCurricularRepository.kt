package com.senai.carteirinha_will.feature.aluno.unidadescurriculares.domain.repository

import com.senai.carteirinha_will.feature.aluno.unidadescurriculares.domain.model.UnidadeCurricular

interface UnidadeCurricularRepository {
    suspend fun listar():Result<List<UnidadeCurricular>>
}