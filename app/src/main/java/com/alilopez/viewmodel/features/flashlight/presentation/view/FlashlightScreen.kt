package com.alilopez.viewmodel.features.flashlight.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alilopez.viewmodel.core.di.HardwareModule
import com.alilopez.viewmodel.core.hardware.data.FlashlightManager
import com.alilopez.viewmodel.features.flashlight.presentation.viewmodel.FlashlightViewModel
import com.alilopez.viewmodel.features.flashlight.presentation.viewmodel.FlashlightViewModelFactory


@Composable
fun FlashlightScreen() {
    val viewModel: FlashlightViewModel = viewModel(
        factory = FlashlightViewModelFactory(HardwareModule.flashlightManager)
    )
    //val viewModel = remember { FlashlightViewModel(FlashlightManager(context)) }
    val isTorchOn by viewModel.isTorchOn.collectAsState<Boolean>()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = if (isTorchOn) "🔦 Linterna Encendida" else "💡 Linterna Apagada",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )
        Button(onClick = { viewModel.toggleTorch() }) {
            Text(if (isTorchOn) "Apagar" else "Encender")
        }
    }
}