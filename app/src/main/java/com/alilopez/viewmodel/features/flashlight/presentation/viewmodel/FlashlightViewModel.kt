package com.alilopez.viewmodel.features.flashlight.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.alilopez.viewmodel.core.hardware.domain.FlashlightRepository
import com.alilopez.viewmodel.core.hardware.domain.VibrateRepository
import com.alilopez.viewmodel.features.rickandmorty.domain.model.Characters
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FlashlightViewModel(
    private val flashlightManager: FlashlightRepository,
    private val vibrateManager: VibrateRepository) : ViewModel() {
    private val _isTorchOn = MutableStateFlow<Boolean>(false)
    val isTorchOn: StateFlow<Boolean> = _isTorchOn

    fun toggleTorch() {
        _isTorchOn.value = !_isTorchOn.value
        flashlightManager.toggleTorch(_isTorchOn.value)
    }

    fun vibrate() {
        vibrateManager.run();
    }
}