package com.alilopez.viewmodel.features.rickandmorty.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.alilopez.viewmodel.features.rickandmorty.data.datasource.local.DataStoreToken
import com.alilopez.viewmodel.features.rickandmorty.domain.repository.TokenRepository
import kotlinx.coroutines.flow.Flow


class TokenRepositoryImpl(
    private val dataStore: DataStoreToken
) : TokenRepository {

    override fun getToken(): Flow<String> = dataStore.getToken()

    override suspend fun saveToken(token: String) = dataStore.saveToken(token)
}