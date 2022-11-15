package com.pchpsky.core.presentation.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pchpsky.core.presentation.theme.DiaryTheme
import com.pchpsky.core.presentation.theme.lightGrey

@Composable
fun RoundedFilledButton(
    text: String, color: Color,
    modifier: Modifier, onClick: () -> Unit,
    enabled: Boolean
) {
    Button(
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color,
            disabledBackgroundColor = lightGrey
        ),
        onClick = onClick,
        modifier = modifier
            .padding(bottom = 12.dp)
            .height(40.dp),
        shape = DiaryTheme.shapes.roundedButton,
        elevation = ButtonDefaults.elevation(
            defaultElevation = 8.dp,
            disabledElevation = 0.dp,
            pressedElevation = 2.dp
        )
    ) {
        Text(text)
    }
}