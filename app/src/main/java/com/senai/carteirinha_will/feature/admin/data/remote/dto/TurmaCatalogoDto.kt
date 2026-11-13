package com.senai.carteirinha_will.feature.admin.data.remote.dto

import com.senai.carteirinha_will.feature.admin.domain.model.TurmaCatalogo
import kotlinx.serialization.Serializable

@Serializable
data class TurmaCatalogoDto(
    val codigo: String,
    val curso: String,
    val unidadesCurriculares: List<String>
) {
    fun toDomain() = TurmaCatalogo(codigo, curso, unidadesCurriculares)
}