package com.alilopez.viewmodel.features.rickandmorty.di

import com.alilopez.viewmodel.core.http.RetrofitHelper
import com.alilopez.viewmodel.features.rickandmorty.data.datasource.remote.CharacterService
import com.alilopez.viewmodel.features.rickandmorty.data.repository.CharacterRepositoryImpl
import com.alilopez.viewmodel.features.rickandmorty.domain.repository.CharacterRepository
import com.alilopez.viewmodel.features.rickandmorty.domain.usecase.GetCharactersUseCase

object AppModule {
    private val api: CharacterService = RetrofitHelper.retrofit.create(CharacterService::class.java)

    private val repository: CharacterRepository = CharacterRepositoryImpl(api)
    val getCharactersUseCase = GetCharactersUseCase(repository)
}