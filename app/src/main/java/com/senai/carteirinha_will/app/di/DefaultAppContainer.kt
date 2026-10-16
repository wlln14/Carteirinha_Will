package com.senai.carteirinha_will.app.di

import com.senai.carteirinha_will.core.auth.SessionTokenStore
import com.senai.carteirinha_will.core.network.NetworkClient
import com.senai.carteirinha_will.feature.aluno.unidadescurriculares.data.remote.service.UnidadeCurricularApi
import com.senai.carteirinha_will.feature.aluno.unidadescurriculares.data.repository.ApiUnidadeCurricularRepositoryImpl
import com.senai.carteirinha_will.feature.aluno.unidadescurriculares.domain.repository.UnidadeCurricularRepository
import com.senai.carteirinha_will.feature.login.data.remote.service.AuthApi
import com.senai.carteirinha_will.feature.login.data.repository.ApiLoginRepositoryImpl
import com.senai.carteirinha_will.feature.login.data.repository.FakeAuthRepository
import com.senai.carteirinha_will.feature.login.domain.repository.LoginRepository

class DefaultAppContainer : AppContainer {
    override val sessionTokenStore: SessionTokenStore = SessionTokenStore()
    private val networkClient = NetworkClient(
        baseUrl = BASE_URL,
        sessionTokenStore = sessionTokenStore
    )

    private val authApi: AuthApi by lazy {
        networkClient.createPublic(AuthApi::class.java)
    }

    private val unidadeCurricularApi: UnidadeCurricularApi by lazy {
        networkClient.createAuthenticated(UnidadeCurricularApi::class.java)
    }

    override val loginRepository: LoginRepository by lazy {
        if (USE_FAKE_LOGIN_REPOSITORY) {
            FakeAuthRepository()
        } else {
            ApiLoginRepositoryImpl(api = authApi)
        }
    }
    override val unidadeCurricularRepository: UnidadeCurricularRepository by lazy {
        ApiUnidadeCurricularRepositoryImpl(api = unidadeCurricularApi)
    }

    companion object {
        private const val BASE_URL = "http://10.0.2.2:8080/"
        private const val USE_FAKE_LOGIN_REPOSITORY = false
    }
}