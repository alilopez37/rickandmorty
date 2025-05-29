package com.alilopez.viewmodel.features.rickandmorty.domain.usecase

import com.alilopez.viewmodel.features.rickandmorty.domain.repository.CharacterRepository

class GetCharactersUseCase(private val repository: CharacterRepository) {
    suspend operator fun invoke() = repository.getCharacters()
}