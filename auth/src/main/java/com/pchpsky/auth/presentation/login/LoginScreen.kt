package com.pchpsky.auth.presentation.login

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.pchpsky.auth.presentation.AuthState
import com.pchpsky.core.presentation.components.ErrorMessage
import com.pchpsky.core.presentation.components.RoundedFilledButton
import com.pchpsky.core.presentation.components.textfield.OutlinedTextField
import com.pchpsky.core.presentation.theme.DiaryTheme
import com.pchpsky.core.presentation.theme.green
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition", "UnusedMaterialScaffoldPaddingParameter")
@ExperimentalComposeUiApi
@Composable
fun LoginScreen(viewModel: LoginViewModel) {

    val login = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val uiState: AuthState by viewModel.uiState.collectAsState()
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    val keyboardController = LocalSoftwareKeyboardController.current

    if (uiState is AuthState.SignupSuccessful) {
        val context = LocalContext.current
//        openHomeScreen(context)
    }

    Scaffold(
        scaffoldState = scaffoldState,
        snackbarHost = { SnackbarHost(it, modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 50.dp)) }) {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(DiaryTheme.colors.background)
                .imePadding()
                .semantics { contentDescription = "Login screen" }
        ) {
            val (column, button, signInTitle) = createRefs()

            Text(
                text = "Sign In",
                style = DiaryTheme.typography.authScreenHeader,
                modifier = Modifier.constrainAs(signInTitle) {
                    top.linkTo(parent.top, 40.dp)
                    start.linkTo(parent.start, 40.dp)
                },
                color = DiaryTheme.colors.text
            )

            Column(
                modifier = Modifier
                    .width(250.dp)
                    .constrainAs(column) {
                        start.linkTo(parent.start, 40.dp)
                        top.linkTo(signInTitle.bottom, 20.dp)
                        end.linkTo(parent.end, 40.dp)
                        width = Dimension.fillToConstraints
                    },
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                LoginTextField(login, null)
                LoginPasswordTextField(password, null)
            }

            RoundedFilledButton(
                "Login",
                modifier = Modifier
                    .constrainAs(button) {
                        start.linkTo(parent.start, 40.dp)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end, 40.dp)
                        width = Dimension.fillToConstraints
                    },
                onClick = {
                    keyboardController?.hide()
                    scope.launch {
                        viewModel.login(login.value, password.value)
                    }
                },
                color = green
            )
        }
        if (uiState is AuthState.AuthenticationError) {
            scope.launch {
                scaffoldState.snackbarHostState.showSnackbar(
                    (uiState as AuthState.AuthenticationError).message,
                )
            }
        }
    }
}

@Composable
fun LoginTextField(login: MutableState<String>, errorMessage: String?) {
    OutlinedTextField(
        login,
        "Login",
        errorMessage,
        KeyboardType.Email,
        VisualTransformation.None
    )
    if (errorMessage != null) {
        ErrorMessage(errorMessage)
    }
}

@Composable
fun LoginPasswordTextField(password: MutableState<String>, errorMessage: String?) {
    OutlinedTextField(
        password,
        "Password",
        errorMessage,
        KeyboardType.Password,
        PasswordVisualTransformation()
    )
}

@ExperimentalComposeUiApi
@Composable
@Preview
fun LoginPreview() {
    DiaryTheme(darkTheme = true) {
//        LoginScreen(FakeAuthViewModel)
    }
}