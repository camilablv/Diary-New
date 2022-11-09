package com.pchpsky.auth.presentation.login

import com.pchpsky.auth.presentation.AuthState
import kotlinx.coroutines.flow.StateFlow

interface LoginViewModel {
    val uiState: StateFlow<AuthState>
    suspend fun login(login: String, password: String)
}