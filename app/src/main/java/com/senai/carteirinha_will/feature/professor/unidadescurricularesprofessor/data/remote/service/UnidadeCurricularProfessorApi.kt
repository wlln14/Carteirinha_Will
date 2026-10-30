package com.senai.carteirinha_will.feature.professor.unidadescurricularesprofessor.data.remote.service

import com.senai.carteirinha_will.feature.professor.unidadescurricularesprofessor.data.remote.dto.UnidadeCurricularProfessorDto
import retrofit2.http.GET

interface UnidadeCurricularProfessorApi {

    @GET("unidades-curriculares")
    suspend fun listar(): List<UnidadeCurricularProfessorDto>
}