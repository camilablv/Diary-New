package com.pchpsky.core.presentation.components

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pchpsky.core.presentation.theme.DiaryTheme
import com.pchpsky.core.presentation.theme.darkGrey
import com.pchpsky.core.presentation.theme.pink
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Clock(
    modifier: Modifier,
    time: String,
    circleRadius: Float,
    outerCircleThickness: Float
) {
    val circleCenter = remember {
        mutableStateOf(Offset.Zero)
    }

    Canvas(
        modifier = modifier
            .background(Color.Green)
    ) {
        val width = size.width
        val height = size.height
        circleCenter.value = Offset(x = width, y = height)
        drawCircle(
            style = Stroke(width = outerCircleThickness),
            brush = Brush.linearGradient(
                listOf(
                    pink,
                    Color(0xFF6a1b9a)
                )
            ),
            radius = circleRadius + outerCircleThickness/2f,
            center = circleCenter.value
        )

        drawCircle(
            brush = Brush.linearGradient(
                listOf(
                    Color(0xff616161),
                    darkGrey
                )
            ),
            radius = circleRadius,
            center = circleCenter.value
        )

        val lineLength = circleRadius * 0.10f

        for (i in 0 until 12) {
            val angleInDegrees = i * 360f / 12
            val angleInRadius = angleInDegrees * PI/180f + PI/2f

            val start = Offset(
                x = (circleRadius * cos(angleInRadius) + circleCenter.value.x).toFloat(),
                y = (circleRadius * sin(angleInRadius) + circleCenter.value.y).toFloat()
            )

            val end = Offset(
                x = (circleRadius * cos(angleInRadius) + circleCenter.value.x).toFloat(),
                y = (circleRadius * sin(angleInRadius) + lineLength + circleCenter.value.y).toFloat()
            )

            rotate(
                angleInDegrees + 180,
                pivot = start
            ) {
                drawLine(
                    color = Color.Gray,
                    start = start,
                    end = end,
                    strokeWidth = 12f,
                    cap = StrokeCap.Round
                )
            }
        }

        val paint = Paint().apply {
            textAlign = Paint.Align.CENTER
            textSize = circleRadius / 1.6f
            color = 0xff00000f.toInt()
            typeface = Typeface.DEFAULT_BOLD
        }

        drawIntoCanvas {
            it.nativeCanvas.drawText(time, circleCenter.value.x, circleCenter.value.y + 48f, paint)
        }
    }
}

@Composable
@Preview
fun ClockPreview() {
    DiaryTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Clock(
                modifier = Modifier
                    .align(Alignment.Center),
                time = "16:15",
                circleRadius = 400f,
                outerCircleThickness = 50f
            )
        }
    }
}