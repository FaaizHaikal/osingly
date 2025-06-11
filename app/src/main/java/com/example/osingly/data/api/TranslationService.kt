package com.example.osingly.data.api

import com.example.osingly.data.model.TranslationRequest
import com.example.osingly.data.model.TranslationResult
import retrofit2.http.Body
import retrofit2.http.POST

interface TranslationService {
    @POST
    suspend fun translate(@Body request: TranslationRequest): TranslationResult
}
