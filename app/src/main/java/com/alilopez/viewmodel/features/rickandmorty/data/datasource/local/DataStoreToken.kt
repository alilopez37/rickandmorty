package com.alilopez.viewmodel.features.rickandmorty.data.datasource.local

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = "settings")

class DataStoreToken(private val context: Context) {

    private val TOKEN = stringPreferencesKey("token")

    suspend fun saveToken(token: String) {
        context.dataStore.edit { preferences -> preferences[TOKEN] = token }
    }

    fun getToken(): Flow<String> {
        return context.dataStore.data.map { preferences ->
                preferences[TOKEN] ?: "Nada de nada" }
    }

    suspend fun delete() {
        context.dataStore.edit { preferences ->
            preferences.remove(TOKEN)
        }
    }

    suspend fun clearAll() {
        context.dataStore.edit { it.clear() }
    }

}