package com.pchpsky.core.presentation.components.textfield

import androidx.compose.compiler.plugins.kotlin.ComposeFqNames.remember
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pchpsky.core.presentation.theme.DiaryTheme

@Composable
fun Clock(
    modifier: Modifier,
    time: () -> Long,
    circleRadius: Float,
    outerCircleThickness: Float
) {
    val circleCenter = remember {
        mutableStateOf(Offset.Zero)
    }

    Box(modifier = Modifier) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            val width = size.width
            val height = size.height
            circleCenter.value = Offset(x = width/2f, y = height/2f)

            drawCircle(
                style = Stroke(width = outerCircleThickness),
                brush = Brush.linearGradient(
                    listOf(
                        Color(0xFFF3F3F3).copy(0.45f),
                        Color(0xFF3F3F3F).copy(0.35f)
                    )
                ),
                radius = circleRadius + outerCircleThickness/2f,
                center = circleCenter.value
            )

            drawCircle(
                brush = Brush.radialGradient(
                    listOf(
                        Color(0xFFF3F3F3).copy(0.45f),
                        Color(0xFF3F3F3F).copy(0.25f)
                    )
                ),
                radius = circleRadius
            )
        }
    }
}

@Composable
@Preview
fun ClockPreview() {
    DiaryTheme {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Clock(
                modifier = Modifier
                    .size(500.dp),
                time = {
                       System.currentTimeMillis()
                },
                circleRadius = 400f,
                outerCircleThickness = 50f
            )
        }
    }
}