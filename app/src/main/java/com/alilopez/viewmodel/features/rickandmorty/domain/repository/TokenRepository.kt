package com.alilopez.viewmodel.features.rickandmorty.domain.repository


interface TokenRepository {
    suspend fun getToken(): String?
    suspend fun saveToken(token: String)
}