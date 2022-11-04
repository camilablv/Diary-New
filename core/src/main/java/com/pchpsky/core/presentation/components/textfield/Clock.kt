package com.pchpsky.core.presentation.components.textfield

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pchpsky.core.presentation.theme.DiaryTheme

@Composable
fun Clock(text: String) {
    DiaryTheme {
        Canvas(
            modifier = Modifier
                .size(150.dp)
                .padding(16.dp),
            onDraw = {
                drawCircle(
                    color = Color.Gray,

                )
            }
        )
    }
}

@Composable
@Preview
fun ClockPreview() {
    DiaryTheme {
        Clock(text = "14:30")
    }
}