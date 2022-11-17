package com.pchpsky.core.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pchpsky.core.presentation.theme.DiaryTheme

data class Value(val text: String, val color: Color)

@Composable
fun <T> Checkbox(
    value: T,
    modifier: Modifier,
    selectedColor: Color,
    text: String,
    select: (T) -> Unit
) {
    Column {
        Row(
            modifier = modifier
                .fillMaxSize()
                .clickable { select(value) }
        ) {
            RadioButton(
                selected = true,
                modifier = Modifier
                    .size(38.dp),
                onClick = {
                    select(value)
                },
                enabled = true,
                colors = RadioButtonDefaults.colors(
                    selectedColor = selectedColor,
                    unselectedColor = White
                )

            )

            Text(
                text = text,
                modifier = Modifier
                    .padding(start = 25.dp)
                    .align(Alignment.CenterVertically),
                style = DiaryTheme.typography.checkbox
            )
        }
    }
}


@Composable
@Preview
fun CheckboxPreview() {
    DiaryTheme {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

        }
    }
}