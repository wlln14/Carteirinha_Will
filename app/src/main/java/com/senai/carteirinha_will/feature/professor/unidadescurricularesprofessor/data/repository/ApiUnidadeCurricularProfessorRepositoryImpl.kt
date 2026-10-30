package com.senai.carteirinha_will.feature.professor.unidadescurricularesprofessor.data.repository

import com.senai.carteirinha_will.feature.professor.unidadescurricularesprofessor.data.remote.service.UnidadeCurricularProfessorApi
import com.senai.carteirinha_will.feature.professor.unidadescurricularesprofessor.domain.model.UnidadeCurricularProfessor
import com.senai.carteirinha_will.feature.professor.unidadescurricularesprofessor.domain.repository.UnidadeCurricularProfessorRepository
import retrofit2.HttpException
import java.io.IOException

class ApiUnidadeCurricularProfessorRepositoryImpl(
    private val api: UnidadeCurricularProfessorApi
) : UnidadeCurricularProfessorRepository {

    override suspend fun listar(): Result<List<UnidadeCurricularProfessor>> {
        return runCatching {
            api.listar().map {
                it.toDomain()
            }
        }.recoverCatching { throwable ->
            throw when (throwable) {
                is HttpException -> {
                    if (throwable.code() == 401) {
                        IllegalStateException("Sua sessão expirou. Faça login novamente.")
                    } else {
                        IllegalStateException("Erro ao carregar unidades curriculares (${throwable.code()}).")
                    }
                }
                is IOException ->
                    IllegalStateException("Não foi possível conectar à API.")
                else ->
                    IllegalStateException(throwable.message ?: "Erro ao carregar unidades curriculares.")
            }
        }
    }
}