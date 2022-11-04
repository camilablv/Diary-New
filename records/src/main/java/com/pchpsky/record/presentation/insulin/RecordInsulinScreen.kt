package com.pchpsky.record.presentation.insulin

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import org.koin.androidx.compose.getViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecordInsulinScreen(viewModel: RecordInsulinViewModelImpl = getViewModel()) {

    val scaffoldState = rememberScaffoldState()

    Scaffold(

    ) {
        LazyColumn {
            item {

            }
        }
    }
}