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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pchpsky.core.presentation.components.Calendar
import com.pchpsky.core.presentation.components.Counter
import com.pchpsky.core.presentation.components.Date
import com.pchpsky.core.presentation.components.Clock
import com.pchpsky.core.presentation.theme.DiaryTheme
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
                    onValueChanged = {}
                )
            }

            item {
                Row(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(32.dp),
                    horizontalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    Calendar(
                        modifier = Modifier,
                        date = Date("08", "Nov"),
                        size = 150.dp)
                    Clock(
                        modifier = Modifier,
                        time = viewState.time,
                        circleRadius = 200f,
                        outerCircleThickness = 50f
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