package com.alilopez.viewmodel.core.hardware.data

import android.content.Context
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import com.alilopez.viewmodel.core.hardware.domain.FlashlightRepository

class FlashlightManager(private val context: Context) : FlashlightRepository {
    private val cameraManager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
    private val cameraId: String? by lazy {
        cameraManager.cameraIdList.firstOrNull { id ->
            cameraManager.getCameraCharacteristics(id).get(CameraCharacteristics.FLASH_INFO_AVAILABLE) == true
        }
    }

    override fun toggleTorch(on: Boolean) {
        cameraId?.let {
            cameraManager.setTorchMode(it, on)
        }
    }

    override fun isTorchAvailable(): Boolean {
        return cameraId != null
    }
}