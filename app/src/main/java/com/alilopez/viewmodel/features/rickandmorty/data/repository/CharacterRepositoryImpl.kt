package com.alilopez.viewmodel.features.rickandmorty.data.repository

import com.alilopez.viewmodel.features.rickandmorty.data.datasource.remote.CharacterService
import com.alilopez.viewmodel.features.rickandmorty.domain.model.Characters
import com.alilopez.viewmodel.features.rickandmorty.domain.repository.CharacterRepository

class CharacterRepositoryImpl(private val api: CharacterService) : CharacterRepository {
    override suspend fun getCharacters(): List<Characters> {
        return api.getCharacters().results.map { it.toDomain() }
    }
}