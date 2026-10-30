package com.senai.carteirinha_will.feature.professor.turmas.presentation

import com.senai.carteirinha_will.feature.professor.turmas.domain.model.TurmasProfessor

data class TurmasProfessorUiState(
    val isLoading: Boolean = false,
    val unidades: List<TurmasProfessor> = emptyList(),
    val errorMessage: String? = null
)