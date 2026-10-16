package com.senai.carteirinha_will.feature.login.domain.repository

import com.senai.carteirinha_will.feature.login.domain.model.UsuarioLogado

interface LoginRepository {
    suspend fun login(login: String, senha: String): Result<UsuarioLogado>
}