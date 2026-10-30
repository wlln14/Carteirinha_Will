package com.senai.carteirinha_will.feature.professor.unidadescurricularesprofessor.presentation

import com.senai.carteirinha_will.feature.professor.unidadescurricularesprofessor.domain.model.UnidadeCurricularProfessor

data class UnidadeCurricularProfessorUiState(
    val isLoading: Boolean = false,
    val unidades: List<UnidadeCurricularProfessor> = emptyList(),
    val errorMessage: String? = null
)