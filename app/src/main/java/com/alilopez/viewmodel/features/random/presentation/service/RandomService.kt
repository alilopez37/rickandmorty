package com.alilopez.viewmodel.features.random.presentation.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.alilopez.viewmodel.R
import com.alilopez.viewmodel.features.random.domain.usecase.GenerateRandomNumberUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class RandomService : Service() {
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    private val generateRandomNumberUseCase = GenerateRandomNumberUseCase()

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        createNotificationChannel()
        startForeground(NOTIFICATION_ID, buildNotification("Iniciando..."))

        scope.launch {
            generateRandomNumberUseCase().collectLatest { number ->
                updateNotification("Número generado: $number")
            }
        }

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        // Cancelar el scope para evitar fugas de memoria
        scope.cancel()

        // Cancelar la notificación manualmente
        stopForeground(STOP_FOREGROUND_REMOVE)

        // Mostrar mensaje Toast al usuario
        Toast.makeText(this, "Servicio detenido", Toast.LENGTH_SHORT).show()
    }

    // Por default la clase Service es una BoundedService, por lo que debemos implementar el método onBind
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    private fun buildNotification(content: String): Notification {
        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Servicio de Números Aleatorios")
            .setContentText(content)
            .setSmallIcon(android.R.drawable.ic_popup_sync)
            .setOnlyAlertOnce(true)
            .build()
    }

    private fun updateNotification(content: String) {
        val notification = buildNotification(content)
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(NOTIFICATION_ID, notification)
    }

    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            CHANNEL_ID,
            "Canal Servicio",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        val manager = getSystemService(NotificationManager::class.java)
        manager.createNotificationChannel(channel)
    }

    companion object {
        private const val CHANNEL_ID = "my_service_channel"
        private const val NOTIFICATION_ID = 1
    }
}