package com.pchpsky.core.presentation.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun DiaryTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    val sysUiController = rememberSystemUiController()
    SideEffect {
        sysUiController.setSystemBarsColor(
            color = colors.background.copy(alpha = .5f),
            darkIcons = !darkTheme
        )
    }

    CompositionLocalProvider(
        LocalDiaryColors provides colors,
        LocalDiaryShapes provides shapes,
        LocalDiaryTypography provides typography,
        LocalDiaryDimens provides  dimens,
        content = content
    )
}

object DiaryTheme {
    val colors: DiaryColors
        @Composable
        get() = LocalDiaryColors.current

    val typography
        @Composable
        get() = LocalDiaryTypography.current

    val shapes
        @Composable
        get() = LocalDiaryShapes.current

    val dimens
        @Composable
        get() = LocalDiaryDimens.current
}