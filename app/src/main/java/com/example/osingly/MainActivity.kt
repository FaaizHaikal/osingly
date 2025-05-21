package com.example.osingly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.osingly.data.api.TranslationApi
import com.example.osingly.data.ocr.OcrHelper
import com.example.osingly.di.AppModule
import com.example.osingly.ui.OcrScreen
import com.example.osingly.ui.theme.OsinglyTheme
import com.example.osingly.viewmodel.OcrViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = AppModule.provideOcrViewModel()

        setContent {
            OsinglyTheme {
                OcrScreen(
                    viewModel = viewModel,
                    onResult = { result ->
                        println("Translation result: $result")
                    }
                )
            }
        }
    }
}