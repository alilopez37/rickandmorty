package com.alilopez.viewmodel.features.rickandmorty.di

import android.content.Context
import com.alilopez.viewmodel.core.http.RetrofitHelper
import com.alilopez.viewmodel.core.store.local.DataStoreManager
import com.alilopez.viewmodel.features.rickandmorty.data.datasource.remote.CharacterService
import com.alilopez.viewmodel.features.rickandmorty.data.repository.CharacterRepositoryImpl
import com.alilopez.viewmodel.features.rickandmorty.data.repository.TokenRepositoryImpl
import com.alilopez.viewmodel.features.rickandmorty.domain.repository.CharacterRepository
import com.alilopez.viewmodel.features.rickandmorty.domain.repository.TokenRepository
import com.alilopez.viewmodel.features.rickandmorty.domain.usecase.GetCharactersUseCase

object AppModule {

    private lateinit var appContext: Context
    private lateinit var dataStoreManager: DataStoreManager

    private var isInitialized = false

    fun init(context: Context) {
        if (!isInitialized) {
            appContext = context.applicationContext
            dataStoreManager = DataStoreManager(appContext)
            RetrofitHelper.init(dataStoreManager)
            isInitialized = true
        }
    }

    // Repository
    private val tokenRepository: TokenRepository by lazy {
        TokenRepositoryImpl(dataStoreManager)
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