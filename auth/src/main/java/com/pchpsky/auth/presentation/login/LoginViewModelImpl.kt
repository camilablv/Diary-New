package com.pchpsky.auth.presentation.login

import androidx.lifecycle.ViewModel
import com.pchpsky.auth.presentation.AuthState
import com.pchpsky.auth.domain.usecase.LoginUseCase
import com.pchpsky.network.errors.NetworkError
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModelImpl(val useCase: LoginUseCase) : ViewModel(), LoginViewModel {

    private val _uiState: MutableStateFlow<AuthState> = MutableStateFlow(AuthState.None)

    override val uiState: StateFlow<AuthState> = _uiState

    override suspend fun login(login: String, password: String) {
        _uiState.value = AuthState.Loading

        useCase.login(login, password).fold(
            {
                when(it) {
                    is NetworkError.ServerError -> { AuthState.ServerError }
                    is NetworkError.AuthenticationError -> { AuthState.AuthenticationError(it.message) }
                    is NetworkError.ValidationError -> { AuthState.ValidationError(it.fields) }
                }
            },
            {
                AuthState.SignupSuccessful
            }
        ).also { _uiState.value = it }
    }
}