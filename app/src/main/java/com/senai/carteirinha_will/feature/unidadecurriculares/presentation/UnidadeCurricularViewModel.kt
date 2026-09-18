package com.senai.carteirinha_will.feature.unidadecurriculares.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UnidadeCurricularViewModel(
    private val repository: UnidadeCurricularRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(UnidadeCurricularUiState())
    val uiState: StateFlow<UnidadeCurricularUiState> = _uiState.asStateFlow()

    fun carregar() {
        viewModelScope.launch {
            _uiState.uptade{
                it.copy(
                    isLoading = false,
                    listaUnidadesCurriculares = listaUnidadesCurriculares,
                    errorMessage = null
                )
            }
        }
    }
}