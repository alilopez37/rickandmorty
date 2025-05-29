package com.alilopez.viewmodel.features.rickandmorty.domain.repository

import com.alilopez.viewmodel.features.rickandmorty.domain.model.Characters

interface CharacterRepository {
    suspend fun getCharacters(): List<Characters>
}