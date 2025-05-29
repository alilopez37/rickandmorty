package com.alilopez.viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.alilopez.viewmodel.features.counter.presentation.CounterScreen
import com.alilopez.viewmodel.features.rickandmorty.presentation.CharacterScreen
import com.alilopez.viewmodel.ui.theme.ViewModelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ViewModelTheme {
                CharacterScreen()
            }
        }
    }
}
