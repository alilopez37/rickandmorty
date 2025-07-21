package com.alilopez.viewmodel.features.random.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alilopez.viewmodel.features.random.presentation.viewmodel.RandomViewModel

@Composable
fun RandomScreen(viewModel: RandomViewModel = viewModel()) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
            .padding(horizontal = 16.dp)
    ){
        Button(
            onClick = {viewModel.onStartRandomService()},
            modifier = Modifier.fillMaxWidth()
                .height(80.dp),
            shape = RoundedCornerShape(16.dp),

            ) {
            Text(text = "Start Service",
                textAlign = TextAlign.Center,
                fontSize = 25.sp ,
            modifier = Modifier.fillMaxWidth())
        }
        Spacer(Modifier.height(10.dp))
        Button(
            onClick = {viewModel.onStopRandomService()},
            modifier = Modifier.fillMaxWidth()
                .height(80.dp),
            shape = RoundedCornerShape(16.dp),

            ) {
            Text(text = "Stop Service",
                textAlign = TextAlign.Center,
                fontSize = 25.sp ,
                modifier = Modifier.fillMaxWidth())
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RandomScreenPreview(){
    RandomScreen()
}

