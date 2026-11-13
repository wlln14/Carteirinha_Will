package com.senai.carteirinha_will.feature.admin.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.senai.carteirinha_will.feature.admin.domain.repository.GestaoSolicitacoesRepository
import com.senai.carteirinha_will.feature.admin.presentation.GestaoSolicitacoesViewModel

class GestaoSolicitacoesViewModelFactory(
    private val repository: GestaoSolicitacoesRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GestaoSolicitacoesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GestaoSolicitacoesViewModel(repository) as T
        }
        throw IllegalArgumentException("ViewModel desconhecido: ${modelClass.name}")
    }
}