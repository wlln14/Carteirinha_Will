package com.senai.carteirinha_will.Navigation

sealed class Routes(val route: String) {
    object Login : Routes("login")
    object Home : Routes("home")
    object Carteirinha : Routes("carteirinha")
    object UnidadeCurricular : Routes("unidade_curricular")
}