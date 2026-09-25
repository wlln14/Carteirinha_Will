package com.senai.carteirinha_will.feature.unidadecurriculares.Domain.repository

import com.senai.carteirinha_will.feature.unidadecurriculares.Domain.model.UnidadeCurricular

interface UnidadeCurricularRepository {
    suspend fun listarUnidadesCurriculares(): Result<List<UnidadeCurricular>>
}