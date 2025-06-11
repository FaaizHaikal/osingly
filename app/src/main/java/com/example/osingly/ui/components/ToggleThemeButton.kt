package com.example.osingly.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ToggleThemeButton(
    isDarkTheme: Boolean,
    onThemeChange: () -> Unit
) {
    IconButton(
        onClick = onThemeChange,
        modifier = Modifier.padding(8.dp)
    ) {
        Icon(
            imageVector = if (isDarkTheme) Icons.Filled.LightMode else Icons.Filled.DarkMode,
            contentDescription = if (isDarkTheme) "Light Mode" else "Dark Mode",
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}