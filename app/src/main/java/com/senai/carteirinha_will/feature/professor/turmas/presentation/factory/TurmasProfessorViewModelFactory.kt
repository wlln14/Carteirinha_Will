package com.senai.carteirinha_will.feature.professor.turmas.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.senai.carteirinha_will.feature.professor.turmas.domain.repository.TurmasProfessorRepository
import com.senai.carteirinha_will.feature.professor.turmas.presentation.TurmasProfessorViewModel

class TurmasProfessorViewModelFactory(
    private val repository: TurmasProfessorRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TurmasProfessorViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TurmasProfessorViewModel(repository = repository) as T
        }
        throw IllegalArgumentException("ViewModel desconhecido: ${modelClass.name}")
    }
}