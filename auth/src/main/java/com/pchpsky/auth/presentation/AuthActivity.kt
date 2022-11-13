package com.pchpsky.auth.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pchpsky.auth.navigation.AuthRoute
import com.pchpsky.auth.presentation.login.LoginScreen
import com.pchpsky.core.presentation.theme.DiaryTheme

class AuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiaryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AuthNavHost(navController = rememberNavController())
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AuthNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AuthRoute.LOGIN.route) {
        composable(AuthRoute.LOGIN.route) {
            LoginScreen {}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DiaryTheme {
    }
}