package com.alilopez.viewmodel.features.rickandmorty.presentation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alilopez.viewmodel.features.rickandmorty.di.AppModule
import androidx.compose.runtime.getValue
import coil.compose.rememberAsyncImagePainter


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterScreen(){
    val viewModel: CharacterViewModel = viewModel(
        factory = CharacterViewModelFactory(AppModule.getCharactersUseCase)
    )
    val characters by viewModel.characters.collectAsState()
    Log.d("CharacterScreen", "Todo Ok")
    Scaffold(
        topBar = { TopAppBar(title = { Text("Rick and Morty Characters") }) }
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            items (characters) { character ->
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)) {
                    Image(
                        painter = rememberAsyncImagePainter(character.image),
                        contentDescription = character.name,
                        modifier = Modifier.size(64.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(character.name, style = MaterialTheme.typography.titleMedium)
                }
            }
        }
    }
}