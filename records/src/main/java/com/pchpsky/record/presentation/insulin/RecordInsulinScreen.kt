package com.pchpsky.record.presentation.insulin

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pchpsky.core.presentation.components.*
import com.pchpsky.core.presentation.theme.DiaryTheme
import com.pchpsky.core.utils.extentions.colorFromHex
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

    val units = remember {
        mutableStateOf(viewState.units.toString())
    }

    LaunchedEffect(true) {
        viewModel.insulins()
    }

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
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Counter(
                    modifier = Modifier,
                    value = units,
                    onValueChanged = { viewModel.setUnits(it.toDouble()) }
                )
            }

            item {
                Row(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(32.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Calendar(
                        modifier = Modifier,
                        date = Date("08", "Nov"),
                        size = 128.dp)
                    Clock(
                        modifier = Modifier,
                        time = viewState.time,
                        circleRadius = 150f,
                        outerCircleThickness = 50f
                    )
                }
            }

            item {
                viewState.insulins.forEach {
                    Checkbox(
                        value = it,
                        modifier = Modifier,
                        selectedColor = Color.Green,
                        text = it.name,
                        select = {

                        }
                    )
                }
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