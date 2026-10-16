package com.senai.carteirinha_will.feature.Login.presentation

import com.senai.carteirinha_will.feature.Login.domain.model.UsuarioLogado

data class LoginUIState (
    val usuario: String = "",
    val senha: String = "",
    val erroMensage: String? = null,
    val isLoading: Boolean = false,
    val usuarioLogado: UsuarioLogado? = null
) {
   val loginRealizado: Boolean
       get() = usuarioLogado != null
}