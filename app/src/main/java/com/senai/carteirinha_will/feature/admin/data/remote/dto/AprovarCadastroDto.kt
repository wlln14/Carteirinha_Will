package com.senai.carteirinha_will.feature.admin.data.remote.dto

import com.senai.carteirinha_will.feature.admin.domain.model.AprovacaoSolicitacao
import kotlinx.serialization.Serializable

@Serializable
data class AtribuicaoDocenteDto(val turma: String, val unidadeCurricular: String)

@Serializable
data class AprovarCadastroDto(
    val turma: String? = null,
    val matricula: String? = null,
    val atribuicoes: List<AtribuicaoDocenteDto>? = null
) {
    companion object {
        fun fromDomain(aprovacao: AprovacaoSolicitacao): AprovarCadastroDto =
            when (aprovacao) {
                is AprovacaoSolicitacao.Aluno -> AprovarCadastroDto(
                    turma = aprovacao.turma,
                    matricula = aprovacao.matricula
                )
                is AprovacaoSolicitacao.Professor -> AprovarCadastroDto(
                    atribuicoes = aprovacao.atribuicoes.map {
                        AtribuicaoDocenteDto(it.turma, it.unidadeCurricular)
                    }
                )
            }
    }
}