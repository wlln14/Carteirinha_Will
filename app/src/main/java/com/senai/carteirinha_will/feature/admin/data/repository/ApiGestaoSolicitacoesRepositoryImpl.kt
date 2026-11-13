package com.senai.carteirinha_will.feature.admin.data.repository

import com.senai.carteirinha_will.core.model.PerfilSolicitado
import com.senai.carteirinha_will.core.network.apiErrorMessage
import com.senai.carteirinha_will.feature.admin.data.remote.dto.AprovarCadastroDto
import com.senai.carteirinha_will.feature.admin.data.remote.service.GestaoSolicitacoesApi
import com.senai.carteirinha_will.feature.admin.domain.model.AprovacaoSolicitacao
import com.senai.carteirinha_will.feature.admin.domain.model.SolicitacaoPendente
import com.senai.carteirinha_will.feature.admin.domain.model.TurmaCatalogo
import com.senai.carteirinha_will.feature.admin.domain.repository.GestaoSolicitacoesRepository
import retrofit2.HttpException


class ApiGestaoSolicitacoesRepositoryImpl(private val api: GestaoSolicitacoesApi) :
    GestaoSolicitacoesRepository {
    override suspend fun listarPendentes(perfil: PerfilSolicitado): Result<List<SolicitacaoPendente>> =
        runCatching { api.listarPendentes(perfil.name).map { it.toDomain() } }
            .recoverCatching { throw IllegalStateException(apiErrorMessage(it)) }

    override suspend fun listarTurmas(): Result<List<TurmaCatalogo>> =
        runCatching { api.listarTurmas().map { it.toDomain() } }
            .recoverCatching { throw IllegalStateException(apiErrorMessage(it)) }

    override suspend fun aprovar(id: String, aprovacao: AprovacaoSolicitacao): Result<Unit> =
        runCatching {
            val response = api.aprovar(id, AprovarCadastroDto.fromDomain(aprovacao))
            if (!response.isSuccessful) throw HttpException(response)
            Unit
        }.recoverCatching { throw IllegalStateException(apiErrorMessage(it)) }

    override suspend fun rejeitar(id: String): Result<Unit> =
        runCatching {
            val response = api.rejeitar(id)
            if (!response.isSuccessful) throw HttpException(response)
            Unit
        }.recoverCatching { throw IllegalStateException(apiErrorMessage(it)) }
}