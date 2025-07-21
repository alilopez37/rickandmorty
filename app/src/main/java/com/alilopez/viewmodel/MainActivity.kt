package com.alilopez.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.alilopez.viewmodel.core.appcontext.AppContextHolder
import com.alilopez.viewmodel.features.flashlight.presentation.view.FlashlightScreen
import com.alilopez.viewmodel.features.random.presentation.view.RandomScreen
import com.alilopez.viewmodel.features.rickandmorty.di.AppModule
import com.alilopez.viewmodel.features.rickandmorty.presentation.CharacterScreen
import com.alilopez.viewmodel.ui.theme.ViewModelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppContextHolder.init(applicationContext)
        enableEdgeToEdge()
        setContent {
            ViewModelTheme {
                RandomScreen()
            }
        }
    }

}
