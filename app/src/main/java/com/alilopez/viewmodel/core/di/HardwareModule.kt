package com.alilopez.viewmodel.core.di

import com.alilopez.viewmodel.core.appcontext.AppContextHolder
import com.alilopez.viewmodel.core.hardware.data.FlashlightManager
import com.alilopez.viewmodel.core.hardware.domain.FlashlightRepository

object HardwareModule {
    fun provideFlashlightRepository(): FlashlightRepository {
        return FlashlightManager(AppContextHolder.get())
    }
}