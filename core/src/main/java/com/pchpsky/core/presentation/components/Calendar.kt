package com.pchpsky.core.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pchpsky.core.presentation.theme.DiaryTheme

@Composable
fun Calendar(text: String) {
    val path = Path().apply {
        moveTo(100f, 50f)
        quadraticBezierTo(10f, 80f,
            300f, 300f)
        lineTo(50f, 10f)
        quadraticBezierTo(90f, 80f, 0f, 0f)
        close()
    }

    Canvas(
        modifier = Modifier
            .size(150.dp)
            .padding(16.dp),
        onDraw = {
            drawRoundRect(
                color = Color.Gray,
                cornerRadius = CornerRadius(16f, 16f)
            )
//            drawPath(
//                path = path,
//                color = Color.Red
//            )
//            drawArc(
//                color = Color.Red,
//                startAngle = 0f,
//                sweepAngle = 50f,
//                topLeft = Offset(50f, 200f),
//                blendMode = BlendMode.ColorBurn,
//                useCenter = true
//            )

            drawRect(
                color = Color.Red,
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
        }
    )
}

@Composable
@Preview
fun CalendarPreview() {
    DiaryTheme {
        Calendar(text = "04 Груд.")
    }
}