package com.example.osingly.di

import com.example.osingly.data.api.TranslationService
import com.example.osingly.data.api.OcrService
import com.example.osingly.viewmodel.OcrViewModel
import com.example.osingly.viewmodel.TranslationViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModule {
    val translationService: TranslationService by lazy {
        Retrofit.Builder()
            .baseUrl("http://your.server.com/") // TODO: replace with real endpoint
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TranslationService::class.java)
    }

    val ocrService = OcrService

    fun provideOcrViewModel(): OcrViewModel {
        return OcrViewModel(ocrService)
    }

    fun provideTranslationViewModel(): TranslationViewModel {
        return TranslationViewModel(translationService)
    }
}