package com.example.osingly.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// Dark theme colors
//private val DarkColorScheme = darkColorScheme(
//    primary = OceanBlue,
//    secondary = SunsetOrange,
//    tertiary = ForestGreen,
//    background = Color(0xFF121212),
//    surface = Color(0xFF1E1E1E),
//    onPrimary = Color.White,
//    onSecondary = Color.Black,
//    onTertiary = Color.White,
//    onBackground = Color(0xFFE0E0E0),
//    onSurface = Color(0xFFE0E0E0),
//    surfaceVariant = Color(0xFF2D2D2D),
//    error = CoralPink
//)
//
//// Light theme colors
//private val LightColorScheme = lightColorScheme(
//    primary = OceanBlue,
//    secondary = GoldYellow,
//    tertiary = ForestGreen,
//    background = Color(0xFFF5F5F5),
//    surface = Color.White,
//    onPrimary = Color.White,
//    onSecondary = Color.Black,
//    onTertiary = Color.White,
//    onBackground = Color(0xFF333333),
//    onSurface = Color(0xFF333333),
//    surfaceVariant = Color(0xFFEEEEEE),
//    error = CoralPink
//)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF446DF6),             // soft blue
    onPrimary = Color.White,
    primaryContainer = Color(0xFFE1E7FF),     // pale blue container
    onPrimaryContainer = Color(0xFF001858),

    secondary = Color(0xFF6750A4),           // indigo/violet
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFEADDFF),
    onSecondaryContainer = Color(0xFF21005D),

    background = Color(0xFFFDFBFF),          // soft white
    onBackground = Color(0xFF1C1B1F),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF1C1B1F),

    surfaceVariant = Color(0xFFE7E0EC),
    onSurfaceVariant = Color(0xFF49454F),

    outline = Color(0xFF79747E),
    error = Color(0xFFB3261E),
    onError = Color.White,
    errorContainer = Color(0xFFF9DEDC),
    onErrorContainer = Color(0xFF410E0B)
)

val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFADB9FF),             // soft blue highlight
    onPrimary = Color(0xFF00105A),
    primaryContainer = Color(0xFF1E1E1E),
    onPrimaryContainer = Color(0xFFE6E1E5),

    secondary = Color(0xFFD0BCFF),           // lavender
    onSecondary = Color(0xFF381E72),
    secondaryContainer = Color(0xFF4F378B),
    onSecondaryContainer = Color(0xFFEADDFF),

    background = Color(0xFF121212),
    onBackground = Color(0xFFE6E1E5),
    surface = Color(0xFF1E1E1E),
    onSurface = Color(0xFFE6E1E5),

    surfaceVariant = Color(0xFF49454F),
    onSurfaceVariant = Color(0xFFCAC4D0),

    outline = Color(0xFF938F99),
    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005),
    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFDAD6)
)

@Composable
fun OsinglyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Disabled for custom colors
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}