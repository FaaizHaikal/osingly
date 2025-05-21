package com.example.osingly.di

import com.example.osingly.data.api.TranslationApi
import com.example.osingly.data.ocr.OcrHelper
import com.example.osingly.viewmodel.OcrViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModule {
    val translationApi: TranslationApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://your.server.com/") // TODO: replace with real endpoint
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TranslationApi::class.java)
    }

    val ocrHelper = OcrHelper

    fun provideOcrViewModel(): OcrViewModel {
        return OcrViewModel(ocrHelper, translationApi)
    }
}