package com.pchpsky.core.presentation.components

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.RemoveCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pchpsky.core.presentation.components.textfield.CounterTextField
import com.pchpsky.core.presentation.theme.DiaryTheme

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Counter(
    modifier: Modifier,
    value: Double,
    increment: () -> Unit,
    decrement: () -> Unit,
    onValueChanged: (String) -> Unit
) {
    val previousValueState = remember { mutableStateOf(value) }

    Row(
        modifier = modifier
            .wrapContentWidth(),
        horizontalArrangement = Arrangement.spacedBy(50.dp)
    ) {
        Box(
            modifier = Modifier
                .background(DiaryTheme.colors.surface, DiaryTheme.shapes.roundedTextField)
        ) {
            AnimatedContent(
                targetState = value,
                transitionSpec = {
                    if (value > previousValueState.value) {
                        slideInVertically { fullHeight -> -fullHeight } + fadeIn() with
                        slideOutVertically { fullHeight -> fullHeight } + fadeOut()
                    } else {
                        slideInVertically { fullHeight -> fullHeight } + fadeIn() with
                        slideOutVertically { fullHeight -> -fullHeight } + fadeOut()
                    }.using(SizeTransform(clip = true))
                }
            ) {
                CounterTextField(value = mutableStateOf(value.toString()), setUnits = onValueChanged)
            }

        }
        Column(
            modifier = Modifier
                .align(Alignment.CenterVertically),
        ) {
            IconButton(
                onClick = {
                    previousValueState.value = value
                    increment()
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
                    previousValueState.value = value
                    decrement()
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
    DiaryTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        ) {
            Counter(
                modifier = Modifier
                    .align(Alignment.Center),
                value = 1.0,
                increment = {},
                decrement = {},
                onValueChanged = {}
            )
        }
    }
}