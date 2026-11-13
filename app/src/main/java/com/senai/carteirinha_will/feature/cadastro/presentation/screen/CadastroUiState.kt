package com.senai.carteirinha_will.feature.cadastro.presentation.screen

import com.senai.carteirinha_will.core.model.PerfilSolicitado

data class CadastroUiState(
    val nome: String = "",
    val login: String = "",
    val senha: String = "",
    val perfil: PerfilSolicitado = PerfilSolicitado.ALUNO,
    val curso: String = "",
    val cursos: List<String> = emptyList(),
    val isLoading: Boolean = false,
    val enviado: Boolean = false,
    val errorMessage: String? = null
)