package com.alilopez.viewmodel.features.rickandmorty.domain.usecase

import com.alilopez.viewmodel.features.rickandmorty.domain.model.Characters
import com.alilopez.viewmodel.features.rickandmorty.domain.repository.CharacterRepository

class GetCharactersUseCase(private val repository: CharacterRepository) {

    suspend operator fun invoke() : Result<List<Characters>> {
        val result  = repository.getCharacters()

        // En caso de existir acá debe estar la lógica de negocio
        return result
    }
}
