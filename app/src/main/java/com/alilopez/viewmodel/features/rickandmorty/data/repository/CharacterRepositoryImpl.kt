package com.alilopez.viewmodel.features.rickandmorty.data.repository

import android.util.Log
import com.alilopez.viewmodel.features.rickandmorty.data.datasource.remote.CharacterService
import com.alilopez.viewmodel.features.rickandmorty.domain.model.Characters
import com.alilopez.viewmodel.features.rickandmorty.domain.repository.CharacterRepository
import retrofit2.HttpException

class CharacterRepositoryImpl(private val api: CharacterService) : CharacterRepository {

    override suspend fun getCharacters(): Result<List<Characters>> {

        return try {
            val response = api.getCharacters()
            Result.success(response.results.map { it.toDomain() })
        } catch (e: HttpException) {
            Result.failure(e)
        }
    }
}