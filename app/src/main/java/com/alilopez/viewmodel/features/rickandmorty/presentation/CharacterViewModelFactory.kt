package com.alilopez.viewmodel.features.rickandmorty.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alilopez.viewmodel.features.rickandmorty.domain.usecase.GetCharactersUseCase

class CharacterViewModelFactory(
    private val useCase: GetCharactersUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CharacterViewModel(useCase) as T
    }
}