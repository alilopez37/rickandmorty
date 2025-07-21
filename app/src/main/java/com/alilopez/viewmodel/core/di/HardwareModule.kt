package com.alilopez.viewmodel.core.di

import com.alilopez.viewmodel.core.appcontext.AppContextHolder
import com.alilopez.viewmodel.core.datastore.DataStoreManager
import com.alilopez.viewmodel.core.hardware.data.FlashlightManager
import com.alilopez.viewmodel.core.hardware.data.VibrateManager
import com.alilopez.viewmodel.core.hardware.domain.FlashlightRepository
import com.alilopez.viewmodel.core.hardware.domain.VibrateRepository

object HardwareModule {
    val flashlightManager: FlashlightRepository by lazy {
        FlashlightManager(AppContextHolder.get())
    }

    val vibrateManager: VibrateRepository by lazy {
        VibrateManager(AppContextHolder.get())
    }
}