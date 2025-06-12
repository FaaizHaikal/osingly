package com.example.osingly.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

@Composable
fun GalleryButton(
    onGalleryClick: () -> Unit
) {
    IconButton(
        onClick = onGalleryClick
    ) {
        Icon(Icons.Filled.Photo, contentDescription = "Galeri")
    }
}