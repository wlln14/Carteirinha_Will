package com.senai.carteirinha_will.feature.cadastro.data.repository

import com.senai.carteirinha_will.core.network.apiErrorMessage
import com.senai.carteirinha_will.feature.cadastro.data.remote.dto.CadastroRequestDto
import com.senai.carteirinha_will.feature.cadastro.data.remote.service.CadastroPublicoApi
import com.senai.carteirinha_will.feature.cadastro.domain.model.SolicitacaoCadastro
import com.senai.carteirinha_will.feature.cadastro.domain.repository.CadastroRepository
import retrofit2.HttpException

class ApiCadastroRepositoryImpl(private val api: CadastroPublicoApi) : CadastroRepository {
    override suspend fun listarCursos(): Result<List<String>> =
        runCatching { api.listarCursos() }.recoverCatching {
            throw IllegalStateException(apiErrorMessage(it))
        }

    override suspend fun solicitarCadastro(solicitacao: SolicitacaoCadastro): Result<Unit> =
        runCatching {
            val response = api.solicitarCadastro(
                CadastroRequestDto(
                    nome = solicitacao.nome,
                    login = solicitacao.login,
                    senha = solicitacao.senha,
                    perfil = solicitacao.perfil.name,
                    curso = solicitacao.curso.orEmpty()
                )
            )
            if (!response.isSuccessful) throw HttpException(response)
            Unit
        }.recoverCatching { throw IllegalStateException(apiErrorMessage(it)) }
}