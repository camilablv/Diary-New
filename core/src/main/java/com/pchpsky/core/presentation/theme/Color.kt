package com.pchpsky.core.presentation.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val lightGreen = Color(0xff5D9A0F)
val green = Color(0xff29771C)
val blue = Color(0xff60A5FF)
val backgroundDark = Color(0xff060b15)
val drawerBackground = Color(0xff1b1b1b)
val lightGrey = Color(0xffa1a1aa)
val errorRed = Color(0xffb71c1c)
val yellow = Color(0xffffff00)
val cardBackground = Color(0xff333333)
val orange = Color(0xffe65100)
val pink = Color(0xffd926a9)

val DarkColors = DiaryColors(
    logo = Color.White,
    background = backgroundDark,
    error = errorRed,
    primary = green,
    secondary = lightGreen,
    drawerBackground = drawerBackground,
    text = Color.White,
    inputField = lightGrey,
    focusedInputFieldBorder = blue,
    unfocusedInputFieldBorder = lightGrey,
    inputText = lightGrey,
    focusedInputFieldLabel = blue,
    cardBackground = cardBackground,
    divider = Color.Gray,
    settingsTopBar = pink,
    recordGlucoseTopBar = orange
)

val LightColors = DiaryColors(
    logo = Color.White,
    background = backgroundDark,
    error = errorRed,
    primary = green,
    secondary = lightGreen,
    drawerBackground = drawerBackground,
    text = Color.White,
    inputField = lightGrey,
    focusedInputFieldBorder = blue,
    unfocusedInputFieldBorder = lightGrey,
    inputText = lightGrey,
    focusedInputFieldLabel = blue,
    cardBackground = cardBackground,
    divider = Color.Black,
    settingsTopBar = pink,
    recordGlucoseTopBar = orange
)

data class DiaryColors(
    val logo: Color,
    val background: Color,
    val primary: Color,
    val error: Color,
    val secondary: Color,
    val drawerBackground: Color,
    val text: Color,
    val inputField: Color,
    val focusedInputFieldBorder: Color,
    val inputText: Color,
    val unfocusedInputFieldBorder: Color,
    val focusedInputFieldLabel: Color,
    val cardBackground: Color,
    val divider: Color,
    val settingsTopBar: Color,
    val recordGlucoseTopBar: Color
)


val LocalDiaryColors = staticCompositionLocalOf<DiaryColors> {
    error("No DiaryColors provided")
}

