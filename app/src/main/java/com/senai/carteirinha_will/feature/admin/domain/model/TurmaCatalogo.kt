package com.senai.carteirinha_will.feature.admin.domain.model

data class TurmaCatalogo(
    val codigo: String,
    val curso: String,
    val unidadesCurriculares: List<String>
)