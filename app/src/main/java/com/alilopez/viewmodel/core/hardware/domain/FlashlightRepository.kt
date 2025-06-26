package com.alilopez.viewmodel.core.hardware.domain

interface FlashlightRepository {
    fun toggleTorch(on: Boolean)
    fun isTorchAvailable(): Boolean
}