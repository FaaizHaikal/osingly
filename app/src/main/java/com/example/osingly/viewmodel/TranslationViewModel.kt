package com.example.osingly.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.osingly.data.api.TranslationService
import com.example.osingly.data.model.TranslationRequest
import kotlinx.coroutines.launch

class TranslationViewModel (
    private val translationService: TranslationService
) : ViewModel() {
    private val _State = mutableStateOf(TranslationState())
    val state: State<TranslationState> = _State

    private fun setState(
        inputText: String? = null,
        translatedText: String? = null,
        fromOsing: Boolean? = null,
        fontSize: Float? = null,
        isLoading: Boolean? = null,
        error: String? = null // This null means "no error", not "keep current error"
    ) {
        _State.value = _State.value.copy(
            inputText = inputText ?: _State.value.inputText,
            translatedText = translatedText ?: _State.value.translatedText,
            fromOsing = fromOsing ?: _State.value.fromOsing,
            fontSize = fontSize ?: _State.value.fontSize,
            isLoading = isLoading ?: _State.value.isLoading,
            error = error // Special case - we want to be able to clear errors with null
        )
    }

    fun translate() {
        viewModelScope.launch {
            setState(isLoading = true, error = null)

            try {
                val response = translationService.translate(
                    TranslationRequest(text = _State.value.inputText, fromOsing = _State.value.fromOsing)
                )

                setState(translatedText = response.text)
            } catch (e: Exception) {
                setState(error = e.localizedMessage)
            } finally {
                setState(isLoading = false)
            }
        }
    }

    fun swapLanguage() {
        setState(fromOsing = !state.value.fromOsing)
    }

    fun updateFontSize(size: Float) {
        setState(fontSize = size)
    }

    fun clearInputText() {
        setState(inputText = "")
    }

    fun updateInputText(text: String) {
        setState(inputText = text)
    }
}