package com.example.osingly;

import android.Manifest;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.osingly.utils.OCRHelper;
import com.example.osingly.utils.TranslationHelper;
import com.google.android.material.button.MaterialButton;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int CAMERA_PERMISSION_CODE = 100;

    // UI Components
    private EditText etInputText;
    private TextView tvOutputText;
    private TextView tvSourceLang;
    private TextView tvTargetLang;
    private TextView tvFontSizeValue;
    private ImageButton btnCamera;
    private ImageButton btnGallery;
    private ImageButton btnClear;
    private ImageButton btnCopy;
    private ImageButton btnShare;
    private ImageButton btnSwapLanguages;
    private ImageButton btnThemeToggle;
    private ImageButton btnSettings;
    private MaterialButton btnTranslate;
    private SeekBar seekBarFontSize;
    private ProgressBar progressBar;

    // Helper classes
    private OCRHelper ocrHelper;
    private TranslationHelper translationHelper;

    // Variables
    private boolean isOsingToIndonesia = true; // true = Osing->Indonesia, false = Indonesia->Osing
    private boolean isDarkMode = false;
    private int currentFontSize = 16;
    private SharedPreferences sharedPreferences;

    // Activity Result Launchers
    private ActivityResultLauncher<Intent> cameraLauncher;
    private ActivityResultLauncher<Intent> galleryLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeHelpers();
        initializeViews();
        initializeActivityLaunchers();
        loadUserPreferences();
        setupEventListeners();
        updateLanguageDisplay();
        updateFontSize();
    }

    private void initializeHelpers() {
        ocrHelper = new OCRHelper();
        translationHelper = new TranslationHelper(this);
    }

    private void initializeViews() {
        etInputText = findViewById(R.id.et_input_text);
        tvOutputText = findViewById(R.id.tv_output_text);
        tvSourceLang = findViewById(R.id.tv_source_lang);
        tvTargetLang = findViewById(R.id.tv_target_lang);
        tvFontSizeValue = findViewById(R.id.tv_font_size_value);
        btnCamera = findViewById(R.id.btn_camera);
        btnGallery = findViewById(R.id.btn_gallery);
        btnClear = findViewById(R.id.btn_clear);
        btnCopy = findViewById(R.id.btn_copy);
        btnShare = findViewById(R.id.btn_share);
        btnSwapLanguages = findViewById(R.id.btn_swap_languages);
        btnThemeToggle = findViewById(R.id.btn_theme_toggle);
        btnSettings = findViewById(R.id.btn_settings);
        btnTranslate = findViewById(R.id.btn_translate);
        seekBarFontSize = findViewById(R.id.seekbar_font_size);
        progressBar = findViewById(R.id.progress_bar);

        sharedPreferences = getSharedPreferences("PenerjemahOsingPrefs", Context.MODE_PRIVATE);
    }

    private void initializeActivityLaunchers() {
        // Camera Launcher
        cameraLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            if (data != null) {
                                Bundle extras = data.getExtras();
                                Bitmap imageBitmap = (Bitmap) extras.get("data");
                                processImageWithOCR(imageBitmap);
                            }
                        }
                    }
                }
        );

        // Gallery Launcher
        galleryLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            if (data != null) {
                                Uri selectedImageUri = data.getData();
                                try {
                                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(
                                            getContentResolver(), selectedImageUri);
                                    processImageWithOCR(bitmap);
                                } catch (IOException e) {
                                    Log.e(TAG, "Error loading image from gallery", e);
                                    Toast.makeText(MainActivity.this,
                                            getString(R.string.image_load_error), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                }
        );
    }

    private void loadUserPreferences() {
        isDarkMode = sharedPreferences.getBoolean("isDarkMode", false);
        currentFontSize = sharedPreferences.getInt("fontSize", 16);
        isOsingToIndonesia = sharedPreferences.getBoolean("isOsingToIndonesia", true);

        // Apply theme
        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        // Set seekbar progress
        seekBarFontSize.setProgress((currentFontSize - 12) / 2);
    }

    private void setupEventListeners() {
        // Translate Button
        btnTranslate.setOnClickListener(v -> translateText());

        // Camera Button
        btnCamera.setOnClickListener(v -> openCamera());

        // Gallery Button
        btnGallery.setOnClickListener(v -> openGallery());

        // Clear Button
        btnClear.setOnClickListener(v -> clearInputText());

        // Copy Button
        btnCopy.setOnClickListener(v -> copyOutputText());

        // Share Button
        btnShare.setOnClickListener(v -> shareOutputText());

        // Swap Languages Button
        btnSwapLanguages.setOnClickListener(v -> swapLanguages());

        // Theme Toggle Button
        btnThemeToggle.setOnClickListener(v -> toggleTheme());

        // Settings Button
        btnSettings.setOnClickListener(v -> openSettings());

        // Font Size SeekBar
        seekBarFontSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    currentFontSize = 12 + (progress * 2); // Range: 12-32sp
                    updateFontSize();
                    saveFontSizePreference();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    private void translateText() {
        String inputText = etInputText.getText().toString().trim();

        if (TextUtils.isEmpty(inputText)) {
            Toast.makeText(this, getString(R.string.empty_input_message),
                    Toast.LENGTH_SHORT).show();
            return;
        }

        // Show progress bar
        progressBar.setVisibility(View.VISIBLE);
        btnTranslate.setEnabled(false);
        btnTranslate.setText(getString(R.string.translating));

        // Perform translation using TranslationHelper
        if (isOsingToIndonesia) {
            translationHelper.translateOsingToIndonesian(inputText, new TranslationHelper.TranslationCallback() {
                @Override
                public void onSuccess(String translatedText) {
                    runOnUiThread(() -> {
                        tvOutputText.setText(translatedText);
                        progressBar.setVisibility(View.GONE);
                        btnTranslate.setEnabled(true);
                        btnTranslate.setText(getString(R.string.translate_button));

                        // Show confidence score
                        double confidence = translationHelper.getTranslationConfidence(inputText, translatedText, true);
                        showTranslationConfidence(confidence);
                    });
                }

                @Override
                public void onFailure(String error) {
                    runOnUiThread(() -> {
                        progressBar.setVisibility(View.GONE);
                        btnTranslate.setEnabled(true);
                        btnTranslate.setText(getString(R.string.translate_button));
                        Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
                    });
                }
            });
        } else {
            translationHelper.translateIndonesianToOsing(inputText, new TranslationHelper.TranslationCallback() {
                @Override
                public void onSuccess(String translatedText) {
                    runOnUiThread(() -> {
                        tvOutputText.setText(translatedText);
                        progressBar.setVisibility(View.GONE);
                        btnTranslate.setEnabled(true);
                        btnTranslate.setText(getString(R.string.translate_button));

                        // Show confidence score
                        double confidence = translationHelper.getTranslationConfidence(inputText, translatedText, false);
                        showTranslationConfidence(confidence);
                    });
                }

                @Override
                public void onFailure(String error) {
                    runOnUiThread(() -> {
                        progressBar.setVisibility(View.GONE);
                        btnTranslate.setEnabled(true);
                        btnTranslate.setText(getString(R.string.translate_button));
                        Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
                    });
                }
            });
        }
    }

    private void showTranslationConfidence(double confidence) {
        String confidenceText;
        if (confidence >= 0.8) {
            confidenceText = "Tinggi";
        } else if (confidence >= 0.5) {
            confidenceText = "Sedang";
        } else {
            confidenceText = "Rendah";
        }

        // You could show this in a subtle way, like a small indicator
        Log.d(TAG, "Translation confidence: " + confidenceText + " (" + confidence + ")");
    }

    private void openCamera() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
            return;
        }

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            cameraLauncher.launch(takePictureIntent);
        }
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        galleryLauncher.launch(intent);
    }

    private void processImageWithOCR(Bitmap bitmap) {
        // Show progress bar
        progressBar.setVisibility(View.VISIBLE);

        ocrHelper.extractTextFromImage(bitmap, new OCRHelper.OCRCallback() {
            @Override
            public void onSuccess(String extractedText) {
                runOnUiThread(() -> {
                    progressBar.setVisibility(View.GONE);

                    if (ocrHelper.isValidForTranslation(extractedText)) {
                        etInputText.setText(extractedText);

                        // Auto-detect language and adjust translation direction
                        autoDetectAndSetLanguage(extractedText);

                        // Ask user if they want to translate immediately
                        showAutoTranslateDialog(extractedText);
                    } else {
                        Toast.makeText(MainActivity.this,
                                "Teks yang diekstrak tidak valid untuk terjemahan",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onFailure(String error) {
                runOnUiThread(() -> {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this,
                            getString(R.string.ocr_extraction_error) + ": " + error,
                            Toast.LENGTH_LONG).show();
                });
            }
        });
    }

    private void autoDetectAndSetLanguage(String text) {
        boolean isOsing = translationHelper.detectLanguage(text);

        if (isOsing != isOsingToIndonesia) {
            // Language direction needs to be swapped
            swapLanguages();
            Toast.makeText(this, "Bahasa terdeteksi dan arah terjemahan disesuaikan",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void showAutoTranslateDialog(String extractedText) {
        new AlertDialog.Builder(this)
                .setTitle("Teks Berhasil Diekstrak")
                .setMessage(getString(R.string.auto_translate_prompt))
                .setPositiveButton(getString(R.string.yes), (dialog, which) -> {
                    translateText();
                })
                .setNegativeButton(getString(R.string.no), null)
                .show();
    }

    private void clearInputText() {
        etInputText.setText("");
        tvOutputText.setText("");
    }

    private void copyOutputText() {
        String outputText = tvOutputText.getText().toString();
        if (TextUtils.isEmpty(outputText)) {
            Toast.makeText(this, getString(R.string.no_text_to_copy), Toast.LENGTH_SHORT).show();
            return;
        }

        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Translated Text", outputText);
        clipboard.setPrimaryClip(clip);

        Toast.makeText(this, getString(R.string.copy_success), Toast.LENGTH_SHORT).show();
    }

    private void shareOutputText() {
        String outputText = tvOutputText.getText().toString();
        if (TextUtils.isEmpty(outputText)) {
            Toast.makeText(this, getString(R.string.no_text_to_share), Toast.LENGTH_SHORT).show();
            return;
        }

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, outputText);
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Terjemahan dari Penerjemah Osing");
        startActivity(Intent.createChooser(shareIntent, getString(R.string.share_text_title)));
    }

    private void swapLanguages() {
        isOsingToIndonesia = !isOsingToIndonesia;
        updateLanguageDisplay();
        saveLanguageDirectionPreference();

        // Swap input and output text if both have content
        String inputText = etInputText.getText().toString();
        String outputText = tvOutputText.getText().toString();

        if (!TextUtils.isEmpty(inputText) && !TextUtils.isEmpty(outputText)) {
            etInputText.setText(outputText);
            tvOutputText.setText(inputText);
        }
    }

    private void updateLanguageDisplay() {
        if (isOsingToIndonesia) {
            tvSourceLang.setText(getString(R.string.language_osing));
            tvTargetLang.setText(getString(R.string.language_indonesia));
            etInputText.setHint(getString(R.string.input_hint_osing));
        } else {
            tvSourceLang.setText(getString(R.string.language_indonesia));
            tvTargetLang.setText(getString(R.string.language_osing));
            etInputText.setHint(getString(R.string.input_hint_indonesia));
        }
    }

    private void toggleTheme() {
        isDarkMode = !isDarkMode;
        saveThemePreference();

        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    private void openSettings() {
        // TODO: Implement settings activity
        Toast.makeText(this, getString(R.string.settings_title), Toast.LENGTH_SHORT).show();
    }

    private void updateFontSize() {
        etInputText.setTextSize(currentFontSize);
        tvOutputText.setTextSize(currentFontSize);
        tvFontSizeValue.setText(currentFontSize + "sp");
    }

    private void saveThemePreference() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isDarkMode", isDarkMode);
        editor.apply();
    }

    private void saveFontSizePreference() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("fontSize", currentFontSize);
        editor.apply();
    }

    private void saveLanguageDirectionPreference() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isOsingToIndonesia", isOsingToIndonesia);
        editor.apply();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera();
            } else {
                Toast.makeText(this, getString(R.string.camera_permission_required),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Clean up resources
        if (ocrHelper != null) {
            ocrHelper.cleanup();
        }
    }
}