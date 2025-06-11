package com.example.osingly.utils

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

object CameraPermission {
    private const val CAMERA_PERMISSION_CODE = 1001
    private val CAMERA_PERMISSION = Manifest.permission.CAMERA

    fun request(activity: Activity) {
        if (ContextCompat.checkSelfPermission(activity, CAMERA_PERMISSION)
            == PackageManager.PERMISSION_GRANTED
        ) {
            // Already granted
            return
        }

        // Request permission
        ActivityCompat.requestPermissions(
            activity,
            arrayOf(CAMERA_PERMISSION),
            CAMERA_PERMISSION_CODE
        )
    }

    fun handleResult(activity: Activity, requestCode: Int, grantResults: IntArray) {
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, do nothing
            } else {
                // Permission denied – exit app
                Toast.makeText(activity, "Camera permission denied", Toast.LENGTH_SHORT).show()
                activity.finish()
            }
        }
    }
}

