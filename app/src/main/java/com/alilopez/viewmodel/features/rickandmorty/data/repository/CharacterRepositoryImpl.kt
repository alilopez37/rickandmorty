package com.alilopez.viewmodel.features.rickandmorty.data.repository

import com.alilopez.viewmodel.features.rickandmorty.data.datasource.remote.CharacterService
import com.alilopez.viewmodel.features.rickandmorty.domain.model.Characters
import com.alilopez.viewmodel.features.rickandmorty.domain.repository.CharacterRepository

class CharacterRepositoryImpl(private val api: CharacterService) : CharacterRepository {
    override suspend fun getCharacters(): Result<List<Characters>> {

        return try {
            val response = api.getCharacters()

            if (response.isSuccessful) {
                Result.success(response.body()!!.results.map { it.toDomain() })
            } else {
                Result.failure(Exception(response.errorBody()?.string()))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }

    }
}