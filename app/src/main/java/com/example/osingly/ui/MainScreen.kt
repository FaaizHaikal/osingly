package com.example.osingly.ui

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import com.example.osingly.ui.components.CameraButton
import com.example.osingly.ui.components.ClearTextButton
import com.example.osingly.ui.components.CopyButton
import com.example.osingly.ui.components.GalleryButton
import com.example.osingly.ui.components.ShareButton
import com.example.osingly.ui.components.SwapLanguageButton
import com.example.osingly.ui.components.ToggleThemeButton
import com.example.osingly.ui.components.TranslateInputField
import com.example.osingly.viewmodel.TranslationViewModel

@Composable
fun MainScreen(
    viewModel: TranslationViewModel,
    onOpenGallery: () -> Unit,
    onOpenCamera: () -> Unit
) {
    val scrollState = rememberScrollState()
    val state by viewModel.state
    val context = LocalContext.current

    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp)
        ) {
            Text(
                text = "Penerjemah Osing",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
//            IconButton(onClick = onSettingsClick) {
//                Icon(Icons.Default.Settings, contentDescription = "Settings")
//            }
            ToggleThemeButton(isDarkTheme = state.isDarkTheme, onThemeChange = viewModel::swapTheme)
        }

        SwapLanguageButton(onSwapLanguages = viewModel::swapLanguage)

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                TranslateInputField(
                    value = state.inputText,
                    onValueChange = { viewModel.updateInputText(it) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    placeholderText = "Ketik teks dalam bahasa Osing...",
                    fontSize = state.fontSize
                )

                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    CameraButton(onCameraClick = onOpenCamera)
                    GalleryButton(onGalleryClick = onOpenGallery)
                    ClearTextButton(onClearInput = viewModel::clearInputText)

                    Button(
                        onClick = viewModel::translate,
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                        ) {
                        Text("Terjemahkan")
                    }
                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = state.translatedText.ifBlank { "Hasil terjemahan akan muncul di sini..." },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .padding(8.dp),
                    fontSize = state.fontSize.sp
                )

                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    CopyButton(onCopyClick = viewModel::clearInputText)
                    ShareButton(onShareClick = viewModel::clearInputText)
                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            elevation = CardDefaults.cardElevation(2.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Ukuran Font:", modifier = Modifier.padding(end = 16.dp))
                Slider(
                    value = state.fontSize,
                    onValueChange = { viewModel.updateFontSize(it) },
                    valueRange = 12f..24f,
                    modifier = Modifier.weight(1f),
                    colors = SliderDefaults.colors(
                        thumbColor = MaterialTheme.colorScheme.primary,
                        activeTrackColor = MaterialTheme.colorScheme.primary,
                        inactiveTrackColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.24f)
                    ),
                )
                Text("${state.fontSize.toInt()}", modifier = Modifier.padding(start = 16.dp))
            }
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        }

        LaunchedEffect(state.error) {
            state.error?.let {
                Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            }
        }
    }
}
