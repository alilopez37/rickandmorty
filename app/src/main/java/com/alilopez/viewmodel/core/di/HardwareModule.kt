package com.alilopez.viewmodel.core.di

import com.alilopez.viewmodel.core.appcontext.AppContextHolder
import com.alilopez.viewmodel.core.datastore.DataStoreManager
import com.alilopez.viewmodel.core.hardware.data.FlashlightManager
import com.alilopez.viewmodel.core.hardware.domain.FlashlightRepository

object HardwareModule {
    val flashlightManager: FlashlightRepository by lazy {
        FlashlightManager(AppContextHolder.get())
    }
}