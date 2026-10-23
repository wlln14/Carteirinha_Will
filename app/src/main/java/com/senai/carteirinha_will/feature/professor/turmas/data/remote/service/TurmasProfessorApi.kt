package com.senai.carteirinha_will.feature.professor.turmas.data.remote.service

import com.senai.carteirinha_will.feature.professor.turmas.data.remote.dto.TurmasProfessorDTO
import retrofit2.http.GET

interface TurmasProfessorApi {

    @GET("turmas")
    suspend fun listar(): List<TurmasProfessorDTO>
}