package com.senai.carteirinha_will.App

import android.app.Application
import com.senai.carteirinha_will.App.di.AppContainer
import com.senai.carteirinha_will.App.di.DefaultAppContainer

class CarteirinhaApplication : Application() {
    val container: AppContainer by lazy {
        DefaultAppContainer()
    }
}