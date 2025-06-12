package com.alilopez.viewmodel.features.rickandmorty.di

import com.alilopez.viewmodel.core.http.RetrofitHelper
import com.alilopez.viewmodel.features.rickandmorty.data.datasource.remote.CharacterService
import com.alilopez.viewmodel.features.rickandmorty.data.repository.CharacterRepositoryImpl
import com.alilopez.viewmodel.features.rickandmorty.domain.repository.CharacterRepository
import com.alilopez.viewmodel.features.rickandmorty.domain.usecase.GetCharactersUseCase

object AppModule {
    private val tokenProvider = {""}
    /*
    private val tokenProvider = {
        context.getSharedPreferences("prefs", Context.MODE_PRIVATE)
            .getString("token", "") ?: ""
    } */

    init {
        RetrofitHelper.init(tokenProvider)
    }

    private val characterService: CharacterService = RetrofitHelper.getService(CharacterService::class.java)

    private val repository: CharacterRepository = CharacterRepositoryImpl(characterService)
    val getCharactersUseCase = GetCharactersUseCase(repository)
}