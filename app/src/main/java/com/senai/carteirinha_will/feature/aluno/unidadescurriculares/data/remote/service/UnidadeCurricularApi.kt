package com.senai.carteirinha_will.feature.aluno.unidadescurriculares.data.remote.service

import com.senai.carteirinha_will.feature.aluno.unidadescurriculares.data.remote.dto.UnidadeCurricularDto
import retrofit2.http.GET

interface UnidadeCurricularApi {

    @GET("unidades-curriculares")
    suspend fun listar(): List<UnidadeCurricularDto>
}