package com.alilopez.viewmodel.features.rickandmorty.domain.repository

import kotlinx.coroutines.flow.Flow


interface TokenRepository {
    suspend fun getToken(): String?
    suspend fun saveToken(token: String)
}