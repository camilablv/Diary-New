package com.pchpsky.core.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import com.pchpsky.core.presentation.theme.DiaryTheme

data class Value(val text: String, val color: Color)

@Composable
fun Checkbox(
    values: List<Value>,
    modifier: Modifier,
    select: (Value) -> Unit
) {
    values.forEach {
        Row(
            modifier = modifier
        ) {
            RadioButton(
                selected = true,
                modifier = Modifier
                    .size(30.dp),
                onClick = {
                    select(it)
                },
                enabled = true,
                colors = RadioButtonDefaults.colors(
                    selectedColor = it.color,
                    unselectedColor = Color.White
                )

            )

            Text(
                text = it.text,
                modifier = Modifier
                    .padding(start = 25.dp)
                    .align(Alignment.CenterVertically),
                style = DiaryTheme.typography.body
            )
        }
    }
}