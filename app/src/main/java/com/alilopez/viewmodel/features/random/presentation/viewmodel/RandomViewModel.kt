package com.alilopez.viewmodel.features.random.presentation.viewmodel

import android.content.Intent
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.alilopez.viewmodel.core.appcontext.AppContextHolder
import com.alilopez.viewmodel.features.random.presentation.service.RandomService

class RandomViewModel : ViewModel() {

    fun onStartRandomService() {
        val startIntent = Intent(AppContextHolder.get(), RandomService::class.java)
        AppContextHolder.get().startService(startIntent)
    }
    fun onStopRandomService() {
        val stopIntent = Intent(AppContextHolder.get(), RandomService::class.java)
        AppContextHolder.get().stopService(stopIntent)
    }

}