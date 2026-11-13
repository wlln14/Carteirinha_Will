package com.senai.carteirinha_will.feature.cadastro.domain.repository

import com.senai.carteirinha_will.feature.cadastro.domain.model.SolicitacaoCadastro

interface CadastroRepository {
    suspend fun listarCursos(): Result<List<String>>
    suspend fun solicitarCadastro(solicitacao: SolicitacaoCadastro): Result<Unit>
}