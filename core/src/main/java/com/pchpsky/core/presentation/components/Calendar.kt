package com.pchpsky.core.presentation.components

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
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

data class Date(val dayOfMonth: String, val month: String)

@Composable
fun Calendar(
    modifier: Modifier,
    date: Date,
    size: Size
) {

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

            for (i in 40 until 320 step 40) {
                drawLine(
                    color = Color.Black,
                    start = Offset(i.toFloat(), 0f),
                    end = Offset(i.toFloat(), 15f),
                    strokeWidth = 16f,
                    cap = StrokeCap.Round
                )
            }

            val paint = Paint().apply {
                textAlign = Paint.Align.CENTER
                textSize = 72f
                color = 0xffffffffff.toInt()
                typeface = Typeface.DEFAULT_BOLD
            }

            drawIntoCanvas {
                it.nativeCanvas.drawText(date.dayOfMonth, center.x, center.y, paint)
            }

            drawIntoCanvas {
                it.nativeCanvas.drawText(date.month, center.x, center.y + 72f, paint)
            }
        }
    )
}

@Composable
@Preview
fun CalendarPreview() {
    val date = Date("11", "Квіт")

    DiaryTheme {
        Box(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Calendar(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp),
                date = date,
                size = Size(320f, 320f)
            )
        }
    }
}