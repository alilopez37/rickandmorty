package com.alilopez.viewmodel.core.http

import com.alilopez.viewmodel.core.http.interceptor.AuthInterceptor
import com.alilopez.viewmodel.core.http.interceptor.provideLoggingInterceptor
import com.alilopez.viewmodel.features.rickandmorty.data.datasource.local.DataStoreToken
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHelper {
    private const val BASE_URL = "https://rickandmortyapi.com/api/"
    private const val TIMEOUT = 20L

    private var retrofit: Retrofit? = null
    private var dataStoreToken : DataStoreToken? = null

    fun init(dataStore : DataStoreToken, extraInterceptors: List<Interceptor> = emptyList()) {
        dataStoreToken = dataStore
        if (retrofit == null) {
            synchronized(this) {
                if (retrofit == null) {
                    retrofit = buildRetrofit(extraInterceptors)
                }
            }
        }
    }

    fun <T> getService(serviceClass: Class<T>): T {
        requireNotNull(retrofit) { "RetrofitClient no ha sido inicializado. Llama a init() primero." }
        return retrofit!!.create(serviceClass)
    }

    private fun buildRetrofit(extraInterceptors: List<Interceptor>): Retrofit {
        val client = buildHttpClient(extraInterceptors)

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun buildHttpClient(extraInterceptors: List<Interceptor>): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(AuthInterceptor(requireNotNull(dataStoreToken)))
            .addInterceptor(provideLoggingInterceptor())
            .apply {
                extraInterceptors.forEach { addInterceptor(it) }
            }
            .build()
    }
}