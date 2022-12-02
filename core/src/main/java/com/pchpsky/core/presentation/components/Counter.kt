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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pchpsky.core.presentation.components.textfield.CounterTextField
import com.pchpsky.core.presentation.theme.DiaryTheme

@OptIn(ExperimentalAnimationApi::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun Counter(
    modifier: Modifier,
    value: Double,
    increment: () -> Unit,
    decrement: () -> Unit,
    onValueChanged: (String) -> Unit
) {
    val initialValueState = value

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
                    if (value > initialValueState) {
                        slideInVertically { fullHeight -> fullHeight } + fadeIn() with
                        slideOutVertically { fullHeight -> -fullHeight } + fadeOut()
                    } else {
                        slideInVertically { fullHeight -> -fullHeight } + fadeIn() with
                        slideOutVertically { fullHeight -> fullHeight } + fadeOut()
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
                onClick = { increment() }
            ) {
                Icon(
                    imageVector = Icons.Rounded.AddCircle,
                    contentDescription = "",
                    modifier = Modifier.size(36.dp),
                    tint = Color.White
                )
            }

            IconButton(
                onClick = { decrement() }
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
                value = 1.0,
                increment = {},
                decrement = {},
                onValueChanged = {}
            )
        }
    }
}