package com.alilopez.viewmodel.core.http.interceptor

import android.util.Log
import com.alilopez.viewmodel.features.rickandmorty.data.datasource.local.DataStoreToken
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(
    private val dataStore: DataStoreToken
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        val token = runBlocking {
            try {
                dataStore.getToken().firstOrNull()
            } catch (e: Exception) {
                Log.e("AuthInterceptor", "Error obteniendo token", e)
                null
            }
        }

        token?.let {
            Log.d("AuthInterceptor", "Token: $it")
            requestBuilder.addHeader("Authorization", "Bearer $it")
        }

        return chain.proceed(requestBuilder.build())
    }
}