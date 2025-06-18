package com.alilopez.viewmodel.core.store.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class DataStoreManager(private val context: Context) {

    val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = "settings")

    suspend fun saveKey(key: Preferences.Key<String>, value: String) {
        context.dataStore.edit { prefs -> prefs[key] = value }
    }

    suspend fun getKey(key: Preferences.Key<String>): String? {
        return context.dataStore.data.first()[key]
    }

    suspend fun removeKey(key: Preferences.Key<*>) {
        context.dataStore.edit { prefs -> prefs.remove(key) }
    }

    suspend fun clearAll() {
        context.dataStore.edit { it.clear() }
    }
}