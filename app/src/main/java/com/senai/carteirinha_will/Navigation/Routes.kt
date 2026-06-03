package com.senai.carteirinha_will.Navigation

sealed class Routes(val route: String) {

    data object Login : Routes("Login")
    data object Carteirinha : Routes("carteirinha")
}