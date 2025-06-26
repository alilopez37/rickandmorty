package com.alilopez.viewmodel.features.flashlight.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alilopez.viewmodel.core.hardware.domain.FlashlightRepository
import com.alilopez.viewmodel.features.rickandmorty.domain.usecase.GetCharactersUseCase
import com.alilopez.viewmodel.features.rickandmorty.presentation.CharacterViewModel


class FlashlightViewModelFactory(
    private val flashlightRepository: FlashlightRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FlashlightViewModel(flashlightRepository) as T
    }
}