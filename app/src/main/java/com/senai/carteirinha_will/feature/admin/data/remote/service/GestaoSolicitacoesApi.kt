package com.senai.carteirinha_will.feature.admin.data.remote.service

import com.senai.carteirinha_will.feature.admin.data.remote.dto.AprovarCadastroDto
import com.senai.carteirinha_will.feature.admin.data.remote.dto.SolicitacaoPendenteDto
import com.senai.carteirinha_will.feature.admin.data.remote.dto.TurmaCatalogoDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface GestaoSolicitacoesApi {
    @GET("admin/solicitacoes")
    suspend fun listarPendentes(@Query("perfil") perfil: String): List<SolicitacaoPendenteDto>

    @GET("admin/catalogo/turmas")
    suspend fun listarTurmas(): List<TurmaCatalogoDto>

    @PUT("admin/solicitacoes/{id}/aprovacao")
    suspend fun aprovar(@Path("id") id: String, @Body dto: AprovarCadastroDto): Response<Void>

    @DELETE("admin/solicitacoes/{id}")
    suspend fun rejeitar(@Path("id") id: String): Response<Void>
}