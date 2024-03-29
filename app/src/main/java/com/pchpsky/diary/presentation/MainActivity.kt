package com.pchpsky.diary.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.pchpsky.auth.presentation.login.LoginScreen
import com.pchpsky.core.presentation.theme.DiaryTheme
import com.pchpsky.diary.presentation.navigation.Routes
import com.pchpsky.record.presentation.insulin.RecordInsulinScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiaryTheme {
                ProvideWindowInsets {
                    NavHost(navController = rememberNavController())
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.LOGIN.route) {
        composable(Routes.LOGIN.route) {
            LoginScreen {
//                navController.navigate(Routes.INSULIN.route)
            }
        }
        composable(Routes.INSULIN.route) {
            RecordInsulinScreen {

            }
        }
    }
}