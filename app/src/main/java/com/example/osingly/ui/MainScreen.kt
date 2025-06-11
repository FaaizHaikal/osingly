package com.example.osingly.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import com.example.osingly.ui.components.CameraButton
import com.example.osingly.ui.components.ClearTextButton
import com.example.osingly.ui.components.CopyButton
import com.example.osingly.ui.components.GalleryButton
import com.example.osingly.ui.components.ShareButton
import com.example.osingly.ui.components.SwapLanguageButton
import com.example.osingly.ui.components.ToggleThemeButton
import com.example.osingly.viewmodel.TranslationViewModel

@Composable
fun MainScreen(
    viewModel: TranslationViewModel
) {
    val scrollState = rememberScrollState()
    val state by viewModel.state

    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp)
        ) {
            Text(
                text = "Penerjemah Osing",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.weight(1f)
            )
//            IconButton(onClick = onSettingsClick) {
//                Icon(Icons.Default.Settings, contentDescription = "Settings")
//            }
            ToggleThemeButton()
        }

        SwapLanguageButton(onSwapLanguages = viewModel::swapLanguage)

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                OutlinedTextField(
                    value = state.inputText,
                    onValueChange = { viewModel.updateInputText(it) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    placeholder = { Text("Ketik teks dalam bahasa Osing...") },
                    textStyle = LocalTextStyle.current.copy(fontSize = state.fontSize.sp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    CameraButton(onCameraClick = viewModel::clearInputText)
                    GalleryButton(onGalleryClick = viewModel::clearInputText)
                    ClearTextButton(onClearInput = viewModel::clearInputText)

                    Button(onClick = viewModel::translate) {
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
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = state.translatedText.ifBlank { "Hasil terjemahan akan muncul di sini..." },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
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
            shape = RoundedCornerShape(12.dp)
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
                    modifier = Modifier.weight(1f)
                )
                Text("${state.fontSize.toInt()}sp", modifier = Modifier.padding(start = 16.dp))
            }
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }
}
