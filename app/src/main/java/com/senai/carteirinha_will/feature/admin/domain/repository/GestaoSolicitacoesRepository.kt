package com.senai.carteirinha_will.feature.admin.domain.repository

import com.senai.carteirinha_will.core.model.PerfilSolicitado
import com.senai.carteirinha_will.feature.admin.domain.model.AprovacaoSolicitacao
import com.senai.carteirinha_will.feature.admin.domain.model.SolicitacaoPendente
import com.senai.carteirinha_will.feature.admin.domain.model.TurmaCatalogo

interface GestaoSolicitacoesRepository {
    suspend fun listarPendentes(perfil: PerfilSolicitado): Result<List<SolicitacaoPendente>>
    suspend fun listarTurmas(): Result<List<TurmaCatalogo>>
    suspend fun aprovar(id: String, aprovacao: AprovacaoSolicitacao): Result<Unit>
    suspend fun rejeitar(id: String): Result<Unit>
}