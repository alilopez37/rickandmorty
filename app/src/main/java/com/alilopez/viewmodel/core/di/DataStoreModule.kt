package com.alilopez.viewmodel.core.di

import com.alilopez.viewmodel.core.appcontext.AppContextHolder
import com.alilopez.viewmodel.core.datastore.DataStoreManager

object DataStoreModule {
    val dataStoreManager: DataStoreManager by lazy {
        DataStoreManager(AppContextHolder.get())
    }
}
