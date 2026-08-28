package com.senai.carteirinha_will.feature.Login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.senai.carteirinha_will.feature.Login.data.repository.FakeLoginRepositoryImpl
import com.senai.carteirinha_will.feature.Login.data.repository.LoginRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: LoginRepository = FakeLoginRepositoryImpl()
): ViewModel() {
    private val _uiState = MutableStateFlow(LoginUIState())
    val uiState: StateFlow<LoginUIState> = _uiState.asStateFlow()

    fun onEvent(event: LoginEvent) {
        when(event) {
            is LoginEvent.OnUsuarioChange -> {
                _uiState.update {
                    state -> state.copy(
                        usuario = event.value,
                        erroMensage = null
                    )
                }
            }
            is LoginEvent.OnSenhaChange -> {
                _uiState.update {
                        state -> state.copy(
                    senha = event.value,
                    erroMensage = null
                )
                }
            }

            LoginEvent.OnNavegacaoRealizada -> {
                _uiState.update {
                    it.copy(
                        usuarioLogado = null
                    )
                }
            }

            LoginEvent.OnEntrarClick -> fazerLogin()

        }
    }

    private fun fazerLogin() {
        val state = _uiState.value

        if (state.usuario.isBlank() || state.senha.isBlank()) {
            _uiState.update {
                it.copy(
                    erroMensage = "preencha login e senha caralho"
                )
            }
        return
        }

        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true,
                    erroMensage = null,
                    usuarioLogado = null
                )
            }
            val result = repository.login(
                state.usuario.trim(),
                state.usuario.trim()
            )

            result
                .onSuccess { usuarioLogado ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            erroMensage = null,
                            usuarioLogado = usuarioLogado
                        )
                    }
                }

                .onFailure { throwable ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            erroMensage = throwable.message ?: "Erro ao fazer login"
                        )
                    }
                }
        }
    }
}