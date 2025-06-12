package com.example.osingly

import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.content.FileProvider
import com.example.osingly.di.AppModule
import com.example.osingly.ui.MainScreen
import com.example.osingly.ui.theme.OsinglyTheme
import com.example.osingly.utils.CameraPermission
import com.example.osingly.viewmodel.TranslationViewModel
import java.io.File

class MainActivity : ComponentActivity() {
    private lateinit var galleryLauncher: ActivityResultLauncher<String>
    private lateinit var cameraLauncher: ActivityResultLauncher<Uri>
    private var tempImageUri: Uri? = null
    private lateinit var translationViewModel: TranslationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CameraPermission.request(this)

        translationViewModel = AppModule.provideTranslationViewModel(applicationContext)

        galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let { translationViewModel.translateImage(it) }
        }

        cameraLauncher = registerForActivityResult(ActivityResultContracts.TakePicture()) { success ->
            if (success) {
                tempImageUri?.let { translationViewModel.translateImage(it) }
            }
        }

        setContent {
            val isDarkTheme = translationViewModel.state.value.isDarkTheme

            OsinglyTheme(darkTheme = isDarkTheme) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(
                        viewModel = translationViewModel,
                        onOpenGallery = { galleryLauncher.launch("image/*") },
                        onOpenCamera = {
                            val uri = getTempFileUri()
                            if (uri != null) {
                                tempImageUri = uri
                                cameraLauncher.launch(uri)
                            } else {
                                Toast.makeText(this, "Failed to create temp file", Toast.LENGTH_SHORT).show()
                            }
                        }
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

    private fun getTempFileUri(): Uri {
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val file = File.createTempFile("osing_${System.currentTimeMillis()}", ".jpg", storageDir)
        return FileProvider.getUriForFile(
            this,
            "${packageName}.fileprovider",
            file
        )
    }
}