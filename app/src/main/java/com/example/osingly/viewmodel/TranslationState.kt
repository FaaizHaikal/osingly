package com.example.osingly.viewmodel

data class TranslationState(
    val inputText: String = "",
    val translatedText: String = "",
    val fromOsing: Boolean = false,
    val fontSize: Float = 20.0F,
    val isLoading: Boolean = false,
    val error: String? = null
)
