package com.senai.carteirinha_will.feature.admin.domain.model

import com.senai.carteirinha_will.core.model.PerfilSolicitado

data class SolicitacaoPendente(
    val id: String,
    val nome: String,
    val login: String,
    val perfilSolicitado: PerfilSolicitado,
    val cursoSolicitado: String
)