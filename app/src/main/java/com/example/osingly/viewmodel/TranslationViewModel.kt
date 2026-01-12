package com.example.osingly.viewmodel

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.osingly.data.api.OcrService
import com.example.osingly.data.api.TranslationService
import com.example.osingly.data.model.TranslationRequest
import com.example.osingly.utils.ImageUtils.uriToBitmap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

class TranslationViewModel (
    private val appContext: Context,
    private val translationService: TranslationService,
    private val ocrService: OcrService
) : ViewModel() {
    private val _State = mutableStateOf(TranslationState())
    val state: State<TranslationState> = _State

    private fun setState(
        inputText: String? = null,
        translatedText: String? = null,
        fromOsing: Boolean? = null,
        fontSize: Float? = null,
        isDarkTheme: Boolean? = null,
        isLoading: Boolean? = null,
        error: String? = null // This null means "no error", not "keep current error"
    ) {
        _State.value = _State.value.copy(
            inputText = inputText ?: _State.value.inputText,
            translatedText = translatedText ?: _State.value.translatedText,
            fromOsing = fromOsing ?: _State.value.fromOsing,
            fontSize = fontSize ?: _State.value.fontSize,
            isDarkTheme = isDarkTheme ?: _State.value.isDarkTheme,
            isLoading = isLoading ?: _State.value.isLoading,
            error = error // Special case - we want to be able to clear errors with null
        )
    }

    fun translateImage(uri: Uri) {
        viewModelScope.launch {
            setState(isLoading = true, error = null)
            try {
                val bitmap = withContext(Dispatchers.IO) {
                    appContext.uriToBitmap(uri) ?: throw Exception("Failed to load image")
                }

                val extractedText = ocrService.extractText(bitmap)
                setState(inputText = extractedText)
                translate()
            } catch (e: Exception) {
                setState(error = e.localizedMessage)
            } finally {
                setState(isLoading = false)
            }
        }
    }

    fun translate() {
        viewModelScope.launch {
            setState(isLoading = true, error = null)

            if (state.value.inputText == "") {
                clearInputText()
                return@launch
            }

            try {
                val response = translationService.translate(
                    TranslationRequest(text = _State.value.inputText, fromOsing = _State.value.fromOsing)
                )

                setState(translatedText = response.text)
            } catch (e: Exception) {
                setState(error = e.localizedMessage)
                Log.e("ERROR", e.localizedMessage)
            } finally {
                setState(isLoading = false)
            }
        }
    }

    fun swapLanguage() {
        setState(fromOsing = !state.value.fromOsing)
    }

    fun swapTheme() {
        setState(isDarkTheme = !state.value.isDarkTheme)
    }

    fun updateFontSize(size: Float) {
        setState(fontSize = size)
    }

    fun clearInputText() {
        setState(inputText = "", translatedText = "")
    }

    fun updateInputText(text: String) {
        setState(inputText = text)
    }
}