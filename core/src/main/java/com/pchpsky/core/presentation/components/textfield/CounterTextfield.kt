package com.pchpsky.core.presentation.components.textfield

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pchpsky.core.presentation.theme.DiaryTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CounterTextField(
    units: MutableState<String>,
    setUnits: (String) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    BasicTextField(
        value = units.value,
        onValueChange = { string ->
            units.value = string
        },
        textStyle = DiaryTheme.typography.insulinUnits,
        modifier = Modifier
            .width(250.dp)
            .height(IntrinsicSize.Min)
            .padding(horizontal = 10.dp)
            .onFocusChanged {
                if (!it.isCaptured) setUnits(units.value)
            },

        decorationBox = {
            it()
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Number
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                setUnits(units.value)
                keyboardController?.hide()
                focusManager.clearFocus()
            }
        ),
        cursorBrush = Brush.verticalGradient(
            0.00f to Color.Transparent,
            0.27f to Color.Transparent,
            0.27f to Color.White,
            0.80f to Color.White,
            0.80f to Color.Transparent,
            1.00f to Color.Transparent
        )
    )
}

@Composable
@Preview
fun CounterTextFieldPreview() {
    DiaryTheme {
        val units = remember {
            mutableStateOf("1.0")
        }

        CounterTextField(units = units, setUnits = {})
    }
}