package com.pchpsky.auth.presentation.login

import androidx.compose.runtime.MutableState
import kotlinx.coroutines.flow.StateFlow

interface LoginViewModel {
    val uiState: StateFlow<LoginViewState>
    val login: MutableState<String>
    val password: MutableState<String>
    suspend fun login(login: String, password: String)
}