package com.senai.carteirinha_will.Navigation

sealed class Routes(val route: String) {
    object Login : Routes("login")
    object Home_Aluno : Routes("homeAluno")
    object Carteirinha : Routes("carteirinha")
    object UnidadeCurricularAluno : Routes("unidade_curricular_aluno")
}