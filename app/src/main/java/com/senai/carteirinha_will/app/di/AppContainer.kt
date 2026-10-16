package com.senai.carteirinha_will.app.di

import com.senai.carteirinha_will.core.auth.SessionTokenStore
import com.senai.carteirinha_will.feature.aluno.unidadescurriculares.domain.repository.UnidadeCurricularRepository
import com.senai.carteirinha_will.feature.login.domain.repository.LoginRepository

interface AppContainer {
    val sessionTokenStore: SessionTokenStore
    val loginRepository: LoginRepository
    val unidadeCurricularRepository: UnidadeCurricularRepository
}
