package com.example.osingly.di

import android.content.Context
import com.example.osingly.data.api.TranslationService
import com.example.osingly.data.api.OcrService
import com.example.osingly.viewmodel.TranslationViewModel
import com.google.android.datatransport.runtime.dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModule {
    private val translationService: TranslationService by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/api/") // TODO: replace with real endpoint
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TranslationService::class.java)
    }

    private val ocrService = OcrService

    @Provides
    fun provideTranslationViewModel(
        context: Context
    ): TranslationViewModel {
        return TranslationViewModel(
            appContext = context.applicationContext,
            ocrService = ocrService,
            translationService = translationService
        )
    }
}