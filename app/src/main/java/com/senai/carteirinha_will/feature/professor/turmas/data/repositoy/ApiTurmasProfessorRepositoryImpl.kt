package com.senai.carteirinha_will.feature.professor.turmas.data.repositoy

import com.senai.carteirinha_will.feature.aluno.unidadescurriculares.domain.model.UnidadeCurricular
import com.senai.carteirinha_will.feature.professor.turmas.data.remote.service.TurmasProfessorApi
import com.senai.carteirinha_will.feature.professor.turmas.domain.model.TurmasProfessor
import com.senai.carteirinha_will.feature.professor.turmas.domain.repository.TurmasProfessorRepository
import retrofit2.HttpException
import java.io.IOException

class ApiTurmasProfessorRepositoryImpl(
    private val api: TurmasProfessorApi
) : TurmasProfessorRepository {

    override suspend fun listar(): Result<List<TurmasProfessor>> {
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