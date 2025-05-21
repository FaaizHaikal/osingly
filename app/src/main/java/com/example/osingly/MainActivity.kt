package com.example.osingly

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.osingly.data.api.TranslationApi
import com.example.osingly.data.ocr.OcrHelper
import com.example.osingly.di.AppModule
import com.example.osingly.ui.OcrScreen
import com.example.osingly.ui.theme.OsinglyTheme
import com.example.osingly.viewmodel.OcrViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {

    private val CAMERA_PERMISSION_CODE = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.CAMERA),
                CAMERA_PERMISSION_CODE
            )
        }

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