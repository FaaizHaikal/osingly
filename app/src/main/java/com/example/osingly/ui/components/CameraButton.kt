package com.example.osingly.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

@Composable
fun CameraButton(
    onCameraClick: () -> Unit
) {
    IconButton(
        onClick = onCameraClick
    ) {
        Icon(Icons.Filled.CameraAlt, contentDescription = "Camera")
    }
}