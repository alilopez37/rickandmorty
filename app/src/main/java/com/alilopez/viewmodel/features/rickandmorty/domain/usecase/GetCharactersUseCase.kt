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
        Log.d("GetCharactersUseCase", "Todo Ok 1")
        result.onSuccess {
                data -> tokenRepository.saveToken("Barier 232323") // Acá va p.e. data.token
        }.onFailure {
                exception -> tokenRepository.saveToken("")
        }
        Log.d("GetCharactersUseCase", "Todo Ok 2")
        // En caso de existir acá debe estar la lógica de negocio
        return result
    }
}
