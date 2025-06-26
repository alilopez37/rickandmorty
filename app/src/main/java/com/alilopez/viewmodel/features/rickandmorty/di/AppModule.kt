package com.alilopez.viewmodel.features.rickandmorty.di

import com.alilopez.viewmodel.core.network.RetrofitHelper
import com.alilopez.viewmodel.core.di.DataStoreModule
import com.alilopez.viewmodel.features.rickandmorty.data.datasource.remote.CharacterService
import com.alilopez.viewmodel.features.rickandmorty.data.repository.CharacterRepositoryImpl
import com.alilopez.viewmodel.features.rickandmorty.data.repository.TokenRepositoryImpl
import com.alilopez.viewmodel.features.rickandmorty.domain.repository.CharacterRepository
import com.alilopez.viewmodel.features.rickandmorty.domain.repository.TokenRepository
import com.alilopez.viewmodel.features.rickandmorty.domain.usecase.GetCharactersUseCase

object AppModule {

    init {
        RetrofitHelper.init()
    }

    // Repository
    private val tokenRepository: TokenRepository by lazy {
        TokenRepositoryImpl(DataStoreModule.dataStoreManager)
    }

    private val characterService: CharacterService by lazy {
        RetrofitHelper.getService(CharacterService::class.java)
    }

    private val repositoryCharacter: CharacterRepository by lazy {
        CharacterRepositoryImpl(characterService)
    }

    val getCharactersUseCase: GetCharactersUseCase by lazy {
        GetCharactersUseCase(repositoryCharacter, tokenRepository)
    }
}