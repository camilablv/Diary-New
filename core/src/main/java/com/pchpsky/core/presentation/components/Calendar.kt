package com.pchpsky.core.presentation.components

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.pchpsky.core.domain.model.Date
import com.pchpsky.core.presentation.theme.*

@Composable
fun Calendar(
    modifier: Modifier,
    date: Date,
    size: Dp
) {
    Canvas(
        modifier = modifier
            .size(size),
        onDraw = {
            val sizeInPx = size.toPx()

            drawRoundRect(
                brush = Brush.linearGradient(
                    listOf(
                        Color(0xff616161),
                        darkGrey
                    )
                ),
                cornerRadius = CornerRadius(sizeInPx/48, sizeInPx/48),
                size = Size(sizeInPx, sizeInPx)
            )

            drawRect(
                brush = Brush.linearGradient(
                    listOf(
                        lightGreen,
                        green
                    )
                ),
                topLeft = Offset(0f, 0f),
                size = Size(sizeInPx, sizeInPx/6),

            )

            for (position in sizeInPx.toInt()/14 until sizeInPx.toInt() step sizeInPx.toInt()/7) {
                drawLine(
                    color = Color.Black,
                    start = Offset(position.toFloat(), 0f),
                    end = Offset(position.toFloat(), sizeInPx/23),
                    strokeWidth = size.toPx()/20,
                    cap = StrokeCap.Round
                )
            }

            val paint = Paint().apply {
                textAlign = Paint.Align.CENTER
                textSize = sizeInPx/3
                color = 0xffffffffff.toInt()
                typeface = Typeface.DEFAULT_BOLD
            }

            drawIntoCanvas {
                it.nativeCanvas.drawText(date.dayOfMonth, center.x, center.y, paint)
            }

            drawIntoCanvas {
                it.nativeCanvas.drawText(date.month, center.x, center.y + sizeInPx/3, paint)
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
                .fillMaxSize()
                .background(DiaryTheme.colors.background),
        ) {
            Calendar(
                modifier = Modifier
                    .align(Alignment.BottomStart),
                date = date,
                size = 250.dp
            )
        }
    }
}