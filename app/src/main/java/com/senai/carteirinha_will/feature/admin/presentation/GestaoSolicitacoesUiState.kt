package com.senai.carteirinha_will.feature.admin.presentation

import com.senai.carteirinha_will.core.model.PerfilSolicitado
import com.senai.carteirinha_will.feature.admin.domain.model.AtribuicaoDocente
import com.senai.carteirinha_will.feature.admin.domain.model.SolicitacaoPendente
import com.senai.carteirinha_will.feature.admin.domain.model.TurmaCatalogo

data class GestaoSolicitacoesUiState(
    val aba: PerfilSolicitado = PerfilSolicitado.ALUNO,
    val pendentes: List<SolicitacaoPendente> = emptyList(),
    val turmas: List<TurmaCatalogo> = emptyList(),
    val selecionado: SolicitacaoPendente? = null,
    val turmaSelecionada: String = "",
    val matricula: String = "",
    val atribuicoes: Set<AtribuicaoDocente> = emptySet(),
    val confirmarRejeicao: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val mensagem: String? = null
) {
    val turmasDisponiveis: List<TurmaCatalogo>
        get() = selecionado?.let { aluno ->
            turmas.filter { it.curso == aluno.cursoSolicitado }
        }.orEmpty()

    val podeAprovar: Boolean get() {
        val candidato = selecionado ?: return false
        if (isLoading) return false
        return when (candidato.perfilSolicitado) {
            PerfilSolicitado.ALUNO -> turmaSelecionada.isNotBlank() &&
                    matricula.isNotBlank() &&
                    turmasDisponiveis.any { it.codigo == turmaSelecionada }
            PerfilSolicitado.PROFESSOR -> atribuicoes.isNotEmpty()
        }
    }
}