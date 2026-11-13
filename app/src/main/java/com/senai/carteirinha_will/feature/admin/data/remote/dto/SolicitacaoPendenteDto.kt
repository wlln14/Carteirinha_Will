package com.senai.carteirinha_will.feature.admin.data.remote.dto

import com.senai.carteirinha_will.core.model.PerfilSolicitado
import com.senai.carteirinha_will.feature.admin.domain.model.SolicitacaoPendente
import kotlinx.serialization.Serializable

@Serializable
data class SolicitacaoPendenteDto(
    val id: String,
    val nome: String,
    val login: String,
    val perfilSolicitado: String,
    val cursoSolicitado: String
) {
    fun toDomain(): SolicitacaoPendente = SolicitacaoPendente(
        id, nome, login, PerfilSolicitado.valueOf(perfilSolicitado), cursoSolicitado
    )
}