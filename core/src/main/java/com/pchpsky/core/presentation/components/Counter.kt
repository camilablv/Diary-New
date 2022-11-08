package com.pchpsky.core.presentation.components

import android.view.WindowInsetsAnimation
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.RemoveCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pchpsky.core.presentation.components.textfield.CounterTextField
import com.pchpsky.core.presentation.theme.DiaryTheme

@Composable
fun Counter(
    modifier: Modifier,
    value: MutableState<String>,
    onValueChanged: (String) -> Unit
) {
    Row(
        modifier = modifier
            .wrapContentWidth(),
        horizontalArrangement = Arrangement.spacedBy(50.dp)
    ) {
        Box(
            modifier = Modifier
                .border(1.dp, DiaryTheme.colors.divider, DiaryTheme.shapes.roundedTextField)
        ) {
            CounterTextField(units = value, setUnits = onValueChanged)


        }
        Column(
            modifier = Modifier
                .align(Alignment.CenterVertically),
        ) {
            IconButton(
                onClick = {
                    onValueChanged(value.value + 1.0)
                }
            ) {
                Icon(
                    imageVector = Icons.Rounded.AddCircle,
                    contentDescription = "",
                    modifier = Modifier.size(36.dp),
                    tint = Color.White
                )
            }

            IconButton(
                onClick = {
                    onValueChanged((value.value.toDouble() - 1.0).toString())
                }
            ) {
                Icon(
                    imageVector = Icons.Rounded.RemoveCircle,
                    contentDescription = null,
                    modifier = Modifier.size(36.dp),
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
@Preview
fun CounterPreview() {
    val units = remember {
        mutableStateOf("1.0")
    }
    DiaryTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        ) {
            Counter(
                modifier = Modifier
                    .align(Alignment.Center),
                value = units,
                onValueChanged = {}
            )
        }
    }
}