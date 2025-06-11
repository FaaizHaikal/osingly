package com.example.osingly.viewmodel

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.osingly.data.api.OcrService
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class OcrViewModel(
    private val ocrService : OcrService
) : ViewModel() {

    private val _extractedText = MutableStateFlow<String?>(null)
    val extractedText: StateFlow<String?> = _extractedText

    val loading = MutableStateFlow(false)
    val error = MutableStateFlow<String?>(null)

    fun extractText(bitmap: Bitmap) {
        viewModelScope.launch {
            loading.value = true
            error.value = null
            try {
                val extractedText = ocrService.extractText(bitmap)
                _extractedText.value = extractedText
            } catch (e: Exception) {
                error.value = e.localizedMessage
            } finally {
                loading.value = false
            }
        }
    }
}