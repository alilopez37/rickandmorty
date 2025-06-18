package com.alilopez.viewmodel.features.rickandmorty.data.model

import com.alilopez.viewmodel.features.rickandmorty.domain.model.Characters


data class Character(
    val id: Int,
    val name: String,
    val image: String
) {
    fun toDomain() = Characters(id, name, image)
}


