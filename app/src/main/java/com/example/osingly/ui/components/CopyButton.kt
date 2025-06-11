package com.example.osingly.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

@Composable
fun CopyButton(
    onCopyClick: () -> Unit
) {
    IconButton(onClick = onCopyClick) {
        Icon(Icons.Filled.ContentCopy, contentDescription = "Salin")
    }
}