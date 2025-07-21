package com.alilopez.viewmodel.features.random.domain.usecase

import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.isActive
import kotlin.random.Random

class GenerateRandomNumberUseCase {
    operator fun invoke(): Flow<Int> = flow {
        val context = currentCoroutineContext()
        while (context.isActive) {
            val number = Random.nextInt(0, 1000)
            emit(number)
            delay(3000L) // Espera 3 segundos
        }
    }
}