package com.senai.carteirinha_will.feature.cadastro.domain.model

import com.senai.carteirinha_will.core.model.PerfilSolicitado

data class SolicitacaoCadastro(
    val nome: String,
    val login: String,
    val senha: String,
    val perfil: PerfilSolicitado,
    val curso: String?
)