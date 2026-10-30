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
import com.senai.carteirinha_will.feature.professor.turmas.data.remote.service.TurmasProfessorApi
import com.senai.carteirinha_will.feature.professor.turmas.data.repositoy.ApiTurmasProfessorRepositoryImpl
import com.senai.carteirinha_will.feature.professor.turmas.domain.repository.TurmasProfessorRepository
import com.senai.carteirinha_will.feature.professor.unidadescurricularesprofessor.data.remote.service.UnidadeCurricularProfessorApi
import com.senai.carteirinha_will.feature.professor.unidadescurricularesprofessor.data.repository.ApiUnidadeCurricularProfessorRepositoryImpl
import com.senai.carteirinha_will.feature.professor.unidadescurricularesprofessor.domain.repository.UnidadeCurricularProfessorRepository

class DefaultAppContainer : AppContainer {
    override val sessionTokenStore: SessionTokenStore = SessionTokenStore()
    private val networkClient = NetworkClient(BASE_URL, sessionTokenStore)

    private val authApi: AuthApi by lazy { networkClient.createPublic(AuthApi::class.java) }
    private val unidadeCurricularApi: UnidadeCurricularApi by lazy { networkClient.createAuthenticated(UnidadeCurricularApi::class.java) }
    private val turmasProfessorApi: TurmasProfessorApi by lazy { networkClient.createAuthenticated(TurmasProfessorApi::class.java) }
    private val unidadeCurricularProfessorApi: UnidadeCurricularProfessorApi by lazy { networkClient.createAuthenticated(UnidadeCurricularProfessorApi::class.java) }

    override val loginRepository: LoginRepository by lazy {
        if (USE_FAKE_LOGIN_REPOSITORY) FakeAuthRepository()
        else ApiLoginRepositoryImpl(api = authApi)
    }
    override val unidadeCurricularRepository: UnidadeCurricularRepository by lazy {
        ApiUnidadeCurricularRepositoryImpl(api = unidadeCurricularApi)
    }
    override val turmasProfessorRepository: TurmasProfessorRepository by lazy {
        ApiTurmasProfessorRepositoryImpl(api = turmasProfessorApi)
    }
    override val unidadeCurricularProfessorRepository: UnidadeCurricularProfessorRepository by lazy {
        ApiUnidadeCurricularProfessorRepositoryImpl(api = unidadeCurricularProfessorApi)
    }

    companion object {
        private const val BASE_URL = "http://10.0.2.2:8080/"
        private const val USE_FAKE_LOGIN_REPOSITORY = false
    }
}