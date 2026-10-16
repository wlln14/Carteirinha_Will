package com.senai.carteirinha_will.feature.Login.data.repository

import com.senai.carteirinha_will.feature.Login.domain.model.UsuarioLogado

interface LoginRepository {
    suspend fun login(usuario: String, senha: String): Result<UsuarioLogado>
}