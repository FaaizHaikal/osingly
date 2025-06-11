package com.example.osingly.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

@Composable
fun ShareButton(
    onShareClick: () -> Unit
) {
    IconButton(onClick = onShareClick) {
        Icon(Icons.Default.Share, contentDescription = "Bagikan")
    }
}