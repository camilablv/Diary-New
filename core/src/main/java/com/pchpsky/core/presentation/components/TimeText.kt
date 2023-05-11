package com.pchpsky.core.presentation.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.pchpsky.core.presentation.theme.DiaryTheme

@Composable
fun TimeText(
    time: String,
    modifier: Modifier
) {
    Text(
        text = time,
        modifier = modifier,
        color = Color.White,
        style = DiaryTheme.typography.time
    )
}