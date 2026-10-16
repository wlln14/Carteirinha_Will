package com.senai.carteirinha_will.App.di

import com.senai.carteirinha_will.Core.Auth.AuthTokenStore
import com.senai.carteirinha_will.Core.Auth.InMemoryAuthTokenStore
import com.senai.carteirinha_will.Core.Network.NetworkClient
import com.senai.carteirinha_will.feature.Login.data.remote.service.AuthApi
import com.senai.carteirinha_will.feature.Login.data.repository.ApiLoginRepositoryImpl
import com.senai.carteirinha_will.feature.Login.data.repository.FakeLoginRepositoryImpl
import com.senai.carteirinha_will.feature.Login.data.repository.LoginRepository
import com.senai.carteirinha_will.feature.unidadecurriculares.Domain.repository.UnidadeCurricularRepository
import com.senai.carteirinha_will.feature.unidadecurriculares.data.remote.service.UnidadeCurricularApi
import com.senai.carteirinha_will.feature.unidadecurriculares.data.repository.ApiUnidadeCurricularRepositoryImpl

class DefaultAppContainer : AppContainer {

    override val authTokenStore: AuthTokenStore = InMemoryAuthTokenStore()
    private val publicNetworkClient = NetworkClient(baseUrl = BASE_URL)

    private val authenticatedNetworkClient = NetworkClient(
        baseUrl = BASE_URL,
        authTokenStore = authTokenStore
    )

    private val authApi: AuthApi by lazy {

        publicNetworkClient.create(AuthApi::class.java)
    }


    private val unidadeCurricularApi:UnidadeCurricularApi by lazy {

        authenticatedNetworkClient.create(UnidadeCurricularApi::class.java)
    }


    override val loginRepository: LoginRepository by lazy {

        if (USE_FAKE_LOGIN_REPOSITORY) {
            FakeLoginRepositoryImpl()

        } else {
            ApiLoginRepositoryImpl(api = authApi)
        }
    }


    override val unidadeCurricularRepository: UnidadeCurricularRepository by lazy {
        ApiUnidadeCurricularRepositoryImpl(api = unidadeCurricularApi)
    }


    companion object {
        private const val BASE_URL ="http://10.0.2.2:8080/"
        private const val USE_FAKE_LOGIN_REPOSITORY =false
    }
}