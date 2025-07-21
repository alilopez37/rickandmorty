package com.alilopez.viewmodel.core.appcontext

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("StaticFieldLeak")
object AppContextHolder {

    private lateinit var context: Context

    fun init(context: Context) {
        this.context = context.applicationContext
    }

    fun get(): Context {
        check(::context.isInitialized) { "AppContextHolder no ha sido inicializado" }
        return context
    }
}