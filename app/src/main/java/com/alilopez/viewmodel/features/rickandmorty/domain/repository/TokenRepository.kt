package com.alilopez.viewmodel.features.rickandmorty.domain.repository

import kotlinx.coroutines.flow.Flow


interface TokenRepository {
    fun getToken(): Flow<String>
    suspend fun saveToken(token: String)
}