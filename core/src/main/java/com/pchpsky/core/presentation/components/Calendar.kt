package com.pchpsky.core.presentation.components

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pchpsky.core.presentation.theme.DiaryTheme
import com.pchpsky.core.presentation.theme.green
import com.pchpsky.core.presentation.theme.lightGreen
import com.pchpsky.core.presentation.theme.lightGrey

@Composable
fun Calendar(day: String, month: String) {

    Canvas(
        modifier = Modifier
            .size(150.dp)
            .padding(16.dp),
        onDraw = {
            drawRoundRect(
                brush = Brush.linearGradient(
                    listOf(
                        Color.Gray.copy(0.40f),
                        Color.Gray
                    )
                ),
                cornerRadius = CornerRadius(16f, 16f)
            )

            drawRect(
                brush = Brush.linearGradient(
                    listOf(
                        lightGreen,
                        green
                    )
                ),
                topLeft = Offset(0f, 0f),
                size = size.copy(325f, 50f),

            )

            drawLine(
                color = Color.Black,
                start = Offset(40f, 0f),
                end = Offset(40f, 15f),
                strokeWidth = 16f,
                cap = StrokeCap.Round
            )

            drawLine(
                color = Color.Black,
                start = Offset(80f, 0f),
                end = Offset(80f, 15f),
                strokeWidth = 16f,
                cap = StrokeCap.Round
            )

            drawLine(
                color = Color.Black,
                start = Offset(120f, 0f),
                end = Offset(120f, 15f),
                strokeWidth = 16f,
                cap = StrokeCap.Round
            )

            drawLine(
                color = Color.Black,
                start = Offset(160f, 0f),
                end = Offset(160f, 15f),
                strokeWidth = 16f,
                cap = StrokeCap.Round
            )

            drawLine(
                color = Color.Black,
                start = Offset(200f, 0f),
                end = Offset(200f, 15f),
                strokeWidth = 16f,
                cap = StrokeCap.Round
            )

            drawLine(
                color = Color.Black,
                start = Offset(240f, 0f),
                end = Offset(240f, 15f),
                strokeWidth = 16f,
                cap = StrokeCap.Round
            )

            drawLine(
                color = Color.Black,
                start = Offset(280f, 0f),
                end = Offset(280f, 15f),
                strokeWidth = 16f,
                cap = StrokeCap.Round
            )

            val paint = Paint().apply {
                textAlign = Paint.Align.CENTER
                textSize = 72f
                color = 0xffffffffff.toInt()
                typeface = Typeface.DEFAULT_BOLD
            }

            drawIntoCanvas {
                it.nativeCanvas.drawText("March", center.x, center.y, paint)
            }

            drawIntoCanvas {
                it.nativeCanvas.drawText("24", center.x, center.y + 72f, paint)
            }
        }
    )
}

@Composable
@Preview
fun CalendarPreview() {
    DiaryTheme {
        Calendar(day = "04", month = "Nov.")
    }
}