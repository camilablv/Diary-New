package com.pchpsky.auth.presentation.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.pchpsky.auth.presentation.AuthState
import com.pchpsky.auth.domain.usecase.LoginUseCase
import com.pchpsky.network.errors.NetworkError
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModelImpl(val useCase: LoginUseCase) : ViewModel(), LoginViewModel {

    private val _uiState: MutableStateFlow<LoginViewState> = MutableStateFlow(LoginViewState())
    override val uiState: StateFlow<LoginViewState> = _uiState

    override val login: MutableState<String> = mutableStateOf(_uiState.value.login)
    override val password: MutableState<String> = mutableStateOf(_uiState.value.password)

    override suspend fun login(login: String, password: String) {
        _uiState.value.loading = true

        useCase.login(login, password).also { authState ->
            when(authState) {
                is AuthState.SignupSuccessful -> {}
                is AuthState.ServerError -> {}
                is AuthState.AuthenticationError -> {}
                is AuthState.ValidationError -> {}
            }
        }
    }
}