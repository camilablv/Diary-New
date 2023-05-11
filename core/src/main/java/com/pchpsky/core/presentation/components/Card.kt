package com.pchpsky.core.presentation.components

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import com.pchpsky.core.presentation.theme.DiaryTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Card_(
    modifier: Modifier,
    shape: Shape,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = DiaryTheme.colors.surface
        ),
        shape = shape,
        onClick = { onClick() }
    ) {
        content()
    }
}