package com.pchpsky.record.presentation.insulin

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pchpsky.core.presentation.components.*
import com.pchpsky.core.presentation.theme.DiaryTheme
import com.pchpsky.core.utils.extentions.fromHex
import org.koin.androidx.compose.getViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecordInsulinScreen(
    viewModel: RecordInsulinViewModelImpl = getViewModel(),
    onBack: () -> Unit
) {

    val viewState by viewModel.uiState.collectAsState()
    val focusManager = LocalFocusManager.current
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val interactionSource = remember { MutableInteractionSource() }

    val units = remember { mutableStateOf(viewState.units.toString()) }

//    LaunchedEffect(true) {
//        viewModel.insulins()
//    }

    Scaffold(
        modifier = Modifier

    ) {
        Box(
            modifier = Modifier
                .background(DiaryTheme.colors.background)
                .fillMaxSize()
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) { focusManager.clearFocus() },
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp)
        ) {
            item {
                Counter(
                    modifier = Modifier,
                    value = viewState.units,
                    increment = viewModel::incrementUnits,
                    decrement = viewModel::decrementUnits,
                    onValueChanged = { viewModel.setUnits(it.toDouble()) }
                )
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .background(Color.White),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Calendar(
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                        date = viewState.date,
                        size = 128.dp)
                    Card_(
                        modifier = Modifier
                            .size(180.dp),
                        shape = DiaryTheme.shapes.circle,
                        onClick = { /*TODO*/ }
                    ) {
                        TimeText(
                            time = viewState.time,
                            modifier = Modifier
                                .background(Color.Red)
                                .align(Alignment.CenterVertically)
                        )
                    }
                }
            }

            item {
                viewState.insulins.forEach { insulin ->
                    Checkbox(
                        value = insulin,
                        modifier = Modifier,
                        selected = viewState.selectedInsulin == insulin,
                        selectedColor = fromHex(insulin.color),
                        text = insulin.name,
                        select = {
                            viewModel.selectInsulin(it)
                        }
                    )
                }
            }

            item {
                Notes(
                    value = viewModel.noteText,
                    modifier = Modifier
                        .imePadding()
                        .clickable {

                        }
                        .onFocusChanged {
                            viewModel.noteTextFialdExpanded(it.hasFocus)
                        },
                    expanded = viewState.noteTextFieldExpanded,
                    onDoneAction = { focusManager.clearFocus() },
                    placeholder = {
                        Text(text = "Type note..", color = Color.White)
                    },
                    expandedMaxLines = 10,
                    collapsedMaxLines = 5
                )
            }
        }
    }
}

@Composable
@Preview
fun RecordInsulinScreenPreview() {
    DiaryTheme {
        RecordInsulinScreen {}
    }
}