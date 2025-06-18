package com.alilopez.viewmodel.features.rickandmorty.domain.usecase

import android.util.Log
import com.alilopez.viewmodel.features.rickandmorty.domain.model.Characters
import com.alilopez.viewmodel.features.rickandmorty.domain.repository.CharacterRepository
import com.alilopez.viewmodel.features.rickandmorty.domain.repository.TokenRepository

class GetCharactersUseCase(
    private val repository: CharacterRepository,
    private val tokenRepository: TokenRepository,
) {

    suspend operator fun invoke(): Result<List<Characters>> {
        val result = repository.getCharacters()

        // Se habilita cuando el token venga en el Body
        result.onSuccess {
                data -> tokenRepository.saveToken("Barier 232323") // Acá va p.e. data.token
        }.onFailure {
                error -> tokenRepository.saveToken("")
        }
        // En caso de existir acá debe estar la lógica de negocio
        return result
    }
}
