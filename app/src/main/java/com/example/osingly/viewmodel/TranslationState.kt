package com.example.osingly.viewmodel

data class TranslationState(
    val inputText: String = "",
    val translatedText: String = "",
    val fromOsing: Boolean = true,
    val fontSize: Float = 16.0F,
    val isDarkTheme: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null
)
