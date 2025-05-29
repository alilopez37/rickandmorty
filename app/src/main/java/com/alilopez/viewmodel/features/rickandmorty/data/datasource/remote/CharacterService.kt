package com.alilopez.viewmodel.features.rickandmorty.data.datasource.remote

import com.alilopez.viewmodel.features.rickandmorty.data.model.CharacterResponseDto
import retrofit2.http.GET

interface CharacterService {
    @GET("character")
    suspend fun getCharacters(): CharacterResponseDto
}