package com.example.osingly

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.osingly.di.AppModule
import com.example.osingly.ui.MainScreen
import com.example.osingly.ui.OcrScreen
import com.example.osingly.ui.theme.OsinglyTheme
import com.example.osingly.utils.CameraPermission

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CameraPermission.request(this)

        val ocrViewModel = AppModule.provideOcrViewModel()
        val TranslationViewModel = AppModule.provideTranslationViewModel()

        setContent {
            val isDarkTheme = TranslationViewModel.state.value.isDarkTheme

            OsinglyTheme(darkTheme = isDarkTheme) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(
                        viewModel = TranslationViewModel
                    )
                }

            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        CameraPermission.handleResult(this, requestCode, grantResults)
    }
}