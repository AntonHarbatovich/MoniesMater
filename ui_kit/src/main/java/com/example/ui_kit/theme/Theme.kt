package com.example.ui_kit.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import com.example.ui_kit.theme.AppTheme.typography


@Composable
fun MoniesMaterTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) darkThemeColors() else lightThemeColors()
    CompositionLocalProvider(
        LocalTypography provides typography,
        LocalColor provides colors,
    ) {
        MaterialTheme(
            colorScheme = colors.materialColors,
            typography = typography.materialTypography,
            content = content
        )
    }

}


object AppTheme {

    val colors: MoniesMaterColors
        @Composable get() = LocalColor.current

    val typography: MoniesMaterTypography
        @Composable get() = LocalTypography.current

    val sizes: Sizes
        @Composable get() = Sizes()
}

internal val LocalColor = staticCompositionLocalOf { lightThemeColors() }
internal val LocalTypography = staticCompositionLocalOf { MoniesMaterTypography() }