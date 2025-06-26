package com.alilopez.viewmodel.features.rickandmorty.data.repository


import com.alilopez.viewmodel.core.datastore.DataStoreManager
import com.alilopez.viewmodel.core.datastore.PreferenceKeys
import com.alilopez.viewmodel.features.rickandmorty.domain.repository.TokenRepository


class TokenRepositoryImpl(
    private val dataStore: DataStoreManager
) : TokenRepository {

    override suspend fun getToken(): String? = dataStore.getKey(PreferenceKeys.TOKEN)

    override suspend fun saveToken(token: String) = dataStore.saveKey(PreferenceKeys.TOKEN, token)
}