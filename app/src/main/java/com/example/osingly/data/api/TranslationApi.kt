package com.example.osingly.data.api

import com.example.osingly.model.TranslationRequest
import com.example.osingly.model.TranslationResult
import retrofit2.http.Body
import retrofit2.http.POST

interface TranslationApi {
    @POST
    suspend fun translate(@Body request: TranslationRequest): TranslationResult
}