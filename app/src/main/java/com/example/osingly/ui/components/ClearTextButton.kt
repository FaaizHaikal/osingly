package com.example.osingly.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

@Composable
fun ClearTextButton(
    onClearInput: () -> Unit
) {
    IconButton(onClick = onClearInput) {
        Icon(Icons.Default.Clear, contentDescription = "Hapus Teks")
    }
}