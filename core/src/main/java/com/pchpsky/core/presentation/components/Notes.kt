package com.pchpsky.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pchpsky.core.presentation.theme.DiaryTheme
import kotlinx.coroutines.flow.StateFlow

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Notes(
    value: MutableState<String>,
    modifier: Modifier,
    expanded: Boolean,
    placeholder: @Composable () -> Unit,
    expandedMaxLines: Int,
    collapsedMaxLines: Int
) {
    val interactionSource = remember { MutableInteractionSource() }

    BasicTextField(
        value = value.value,
        onValueChange = {
            value.value = it
        },
        modifier = modifier
            .background(DiaryTheme.colors.surface, DiaryTheme.shapes.roundedTextField)
            .fillMaxWidth()
            .clickable {

            },
        textStyle = DiaryTheme.typography.checkbox,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Text
        ),
        maxLines = if (expanded) expandedMaxLines else collapsedMaxLines
    ) { textField ->
        TextFieldDefaults.TextFieldDecorationBox(
            value = value.value,
            innerTextField = textField,
            enabled = true,
            singleLine = false,
            visualTransformation = VisualTransformation.None,
            interactionSource = interactionSource,
            colors = TextFieldDefaults.outlinedTextFieldColors(

            ),
            placeholder = placeholder
        )


    }
}

@Composable
@Preview
fun NotesPreview() {
    val text = remember {
        mutableStateOf("Once we have the width of our text field boundaries and we know how to calculate the width of our text, it’s not that complicated to find desired font size. We are going to compare those two values, and we will continue to decrease our default font size and recalculate our instrinsics, until our text width becomes smaller than the text field’s width.")
    }
    val expanded = remember {
        mutableStateOf(true)
    }

    DiaryTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DiaryTheme.colors.background)
        ) {
            Notes(
                value = text,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
                    .imePadding(),
                expanded = expanded.value,
                placeholder = {
                    Text(text = "Type note..")
                },
                expandedMaxLines = 10,
                collapsedMaxLines = 5
            )
        }
    }
}