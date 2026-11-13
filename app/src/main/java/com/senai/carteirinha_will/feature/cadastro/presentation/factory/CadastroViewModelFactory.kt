package com.senai.carteirinha_will.feature.cadastro.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.senai.carteirinha_will.feature.cadastro.domain.repository.CadastroRepository
import com.senai.carteirinha_will.feature.cadastro.presentation.screen.CadastroViewModel


class CadastroViewModelFactory(private val repository: CadastroRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CadastroViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CadastroViewModel(repository) as T
        }
        throw IllegalArgumentException("ViewModel desconhecido: ${modelClass.name}")
    }
}