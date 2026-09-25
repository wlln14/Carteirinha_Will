package com.senai.carteirinha_will.App.di

import com.senai.carteirinha_will.Core.Auth.AuthTokenStore
import com.senai.carteirinha_will.feature.Login.data.repository.LoginRepository
import com.senai.carteirinha_will.feature.unidadecurriculares.Domain.repository.UnidadeCurricularRepository


interface AppContainer {

    val loginRepository: LoginRepository

    val unidadeCurricularRepository: UnidadeCurricularRepository

    val authTokenStore: AuthTokenStore
}