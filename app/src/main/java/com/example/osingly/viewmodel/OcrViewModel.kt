package com.example.osingly.viewmodel

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.osingly.data.api.TranslationApi
import com.example.osingly.data.ocr.OcrHelper
import com.example.osingly.model.TranslationRequest
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class OcrViewModel(
    private val ocrHelper: OcrHelper,
    private val translationApi: TranslationApi
) : ViewModel() {

    private val _translatedText = MutableStateFlow<String?>(null)
    val translatedText: StateFlow<String?> = _translatedText

    val loading = MutableStateFlow(false)
    val error = MutableStateFlow<String?>(null)

    fun processBitmap(bitmap: Bitmap, fromOsing: Boolean = true) {
        viewModelScope.launch {
            loading.value = true
            error.value = null
            try {
                val extractedText = ocrHelper.extractTextFromImage(bitmap)
                val response = translationApi.translate(
                    TranslationRequest(text = extractedText, fromOsing = fromOsing)
                )
                _translatedText.value = response.text
            } catch (e: Exception) {
                error.value = e.localizedMessage
            } finally {
                loading.value = false
            }
        }
    }
}