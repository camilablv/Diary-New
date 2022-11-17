package com.pchpsky.core.utils.extentions

import android.graphics.Color.parseColor
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

fun Color.toHex(): String {
    return "#" + Integer.toHexString(toArgb()).drop(2)
}

fun fromHex(hexColor: String): Color {
    return Color(parseColor(hexColor))
}