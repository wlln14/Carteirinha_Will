package com.senai.carteirinha_will.App.session

import androidx.lifecycle.ViewModel
import com.senai.carteirinha_will.Core.Auth.AuthTokenStore
import com.senai.carteirinha_will.feature.Login.domain.model.UsuarioLogado
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SessionViewModel(
    private val authTokenStore: AuthTokenStore
) : ViewModel() {

    private val _usuarioLogado = MutableStateFlow<UsuarioLogado?>(null)
    val usuarioLogado: StateFlow<UsuarioLogado?> = _usuarioLogado.asStateFlow()

    fun setUsuarioLogado(usuario: UsuarioLogado) {
        authTokenStore.setToken(usuario.token)
        _usuarioLogado.value = usuario
    }

    fun limparSession() {
        authTokenStore.clearToken()
        _usuarioLogado.value = null
    }
}
