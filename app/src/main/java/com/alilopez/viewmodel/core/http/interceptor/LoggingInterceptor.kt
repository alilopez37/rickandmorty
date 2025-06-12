package com.alilopez.viewmodel.core.http.interceptor

import okhttp3.logging.HttpLoggingInterceptor


fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
}