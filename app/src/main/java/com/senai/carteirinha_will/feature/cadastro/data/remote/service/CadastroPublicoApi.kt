package com.senai.carteirinha_will.feature.cadastro.data.remote.service

import com.senai.carteirinha_will.feature.cadastro.data.remote.dto.CadastroRequestDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CadastroPublicoApi {
    @GET("public/cursos")
    suspend fun listarCursos(): List<String>

    @POST("public/cadastros")
    suspend fun solicitarCadastro(@Body request: CadastroRequestDto): Response<Void>
}