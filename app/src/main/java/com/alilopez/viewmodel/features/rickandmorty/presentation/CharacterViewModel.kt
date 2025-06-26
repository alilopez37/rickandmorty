package com.alilopez.viewmodel.features.rickandmorty.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alilopez.viewmodel.features.rickandmorty.domain.model.Characters
import com.alilopez.viewmodel.features.rickandmorty.domain.usecase.GetCharactersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _characters = MutableStateFlow<List<Characters>>(emptyList())
    val characters: StateFlow<List<Characters>> = _characters

    private var _error = MutableStateFlow<String>("")
    val error : StateFlow<String> = _error

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        viewModelScope.launch {
            val result = getCharactersUseCase()
            Log.d("fetchCharacters","Todo OK")
            result.onSuccess {
                    data -> _characters.value = data
            }.onFailure {
                    exception -> _error.value = exception.message ?: "Error desconocido"
            }
        }
    }
}