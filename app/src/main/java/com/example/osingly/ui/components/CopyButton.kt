package com.example.osingly.ui.components

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@SuppressLint("ServiceCast")
@Composable
fun CopyButton(
    textToCopy: String
) {
    val context = LocalContext.current
    IconButton(onClick = {
        // Copy to clipboard
        val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("translation", textToCopy)
        clipboardManager.setPrimaryClip(clipData)

    }) {
        Icon(Icons.Filled.ContentCopy, contentDescription = "Salin")
    }
}