package com.example.osingly.utils;

import android.graphics.Bitmap;
import android.util.Log;

import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;

/**
 * Helper class for OCR (Optical Character Recognition) using Google ML Kit
 */
public class OCRHelper {

    private static final String TAG = "OCRHelper";
    private TextRecognizer textRecognizer;

    public interface OCRCallback {
        void onSuccess(String extractedText);
        void onFailure(String error);
    }

    public OCRHelper() {
        // Initialize text recognizer for Latin script
        textRecognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);
    }

    /**
     * Extract text from bitmap image
     * @param bitmap The image to process
     * @param callback Callback to handle success/failure
     */
    public void extractTextFromImage(Bitmap bitmap, OCRCallback callback) {
        if (bitmap == null) {
            callback.onFailure("Gambar tidak valid");
            return;
        }

        try {
            InputImage image = InputImage.fromBitmap(bitmap, 0);

            textRecognizer.process(image)
                    .addOnSuccessListener(visionText -> {
                        String extractedText = processVisionText(visionText);
                        if (extractedText.isEmpty()) {
                            callback.onFailure("Tidak ada teks yang terdeteksi dalam gambar");
                        } else {
                            callback.onSuccess(extractedText);
                        }
                    })
                    .addOnFailureListener(e -> {
                        Log.e(TAG, "Text recognition failed", e);
                        callback.onFailure("Gagal mengenali teks: " + e.getMessage());
                    });

        } catch (Exception e) {
            Log.e(TAG, "Error processing image", e);
            callback.onFailure("Error memproses gambar: " + e.getMessage());
        }
    }

    /**
     * Process the vision text result and extract meaningful text
     * @param visionText The result from ML Kit text recognition
     * @return Extracted text as string
     */
    private String processVisionText(Text visionText) {
        StringBuilder resultText = new StringBuilder();

        for (Text.TextBlock block : visionText.getTextBlocks()) {
            String blockText = block.getText();
            resultText.append(blockText).append("\n");
        }

        return resultText.toString().trim();
    }

    /**
     * Process text with additional formatting and cleaning
     * @param visionText The result from ML Kit text recognition
     * @return Cleaned and formatted text
     */
    private String processVisionTextDetailed(Text visionText) {
        StringBuilder resultText = new StringBuilder();

        for (Text.TextBlock block : visionText.getTextBlocks()) {
            for (Text.Line line : block.getLines()) {
                String lineText = line.getText();

                // Clean up the text
                lineText = cleanExtractedText(lineText);

                if (!lineText.trim().isEmpty()) {
                    resultText.append(lineText).append("\n");
                }
            }
        }

        return resultText.toString().trim();
    }

    /**
     * Clean extracted text by removing unwanted characters and formatting
     * @param text Raw extracted text
     * @return Cleaned text
     */
    private String cleanExtractedText(String text) {
        if (text == null) return "";

        // Remove extra whitespaces
        text = text.replaceAll("\\s+", " ");

        // Remove special characters that might interfere with translation
        text = text.replaceAll("[^\\p{L}\\p{N}\\p{P}\\p{Z}]", "");

        // Trim whitespace
        text = text.trim();

        return text;
    }

    /**
     * Release resources
     */
    public void cleanup() {
        if (textRecognizer != null) {
            textRecognizer.close();
        }
    }

    /**
     * Check if the extracted text likely contains Osing language characteristics
     * @param text The extracted text
     * @return true if text appears to be Osing, false otherwise
     */
    public boolean isLikelyOsingText(String text) {
        if (text == null || text.trim().isEmpty()) {
            return false;
        }

        // Convert to lowercase for checking
        String lowerText = text.toLowerCase();

        // Common Osing words/patterns (this would need to be expanded with actual Osing vocabulary)
        String[] osingPatterns = {
                "kulo", "panjenengan", "ngaten", "nggih", "mboten",
                "saking", "dhateng", "wonten", "niku", "niki"
        };

        // Check if any Osing patterns are present
        for (String pattern : osingPatterns) {
            if (lowerText.contains(pattern)) {
                return true;
            }
        }

        // Additional heuristics could be added here
        // For example, checking character frequency, word structure, etc.

        return false;
    }

    /**
     * Validate if the extracted text is suitable for translation
     * @param text The extracted text
     * @return true if text is valid for translation
     */
    public boolean isValidForTranslation(String text) {
        if (text == null || text.trim().isEmpty()) {
            return false;
        }

        // Check minimum length
        if (text.trim().length() < 2) {
            return false;
        }

        // Check if text contains mostly letters (not just numbers/symbols)
        long letterCount = text.chars()
                .filter(Character::isLetter)
                .count();

        double letterRatio = (double) letterCount / text.length();

        // At least 30% of characters should be letters
        return letterRatio >= 0.3;
    }
}