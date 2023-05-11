package com.pchpsky.auth.presentation.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.pchpsky.auth.domain.AuthState
import com.pchpsky.auth.domain.usecase.LoginUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModelImpl(private val useCase: LoginUseCase) : ViewModel(), LoginViewModel {

    private val _uiState: MutableStateFlow<LoginViewState> = MutableStateFlow(LoginViewState())
    override val uiState: StateFlow<LoginViewState> = _uiState

    override val login = mutableStateOf(_uiState.value.login)
    override val password = mutableStateOf(_uiState.value.password)

    override suspend fun login(login: String, password: String) {
        _uiState.value.loading = true

        useCase.login(login, password).also { authState ->
            when(authState) {
                is AuthState.SignupSuccessful -> {
                    _uiState.value = _uiState.value.copy(sighInSuccessful = true)
                }
                is AuthState.ServerError -> { TODO() }
                is AuthState.AuthenticationError -> {
                    _uiState.value = _uiState.value.copy(authError = authState.message)
                }
                is AuthState.ValidationError -> { parseValidationError(authState.fields) }
            }
        }
    }

    private fun parseValidationError(fields: Map<String, ArrayList<String>>) {
        fields.forEach {
            when(it.key) {
                "email" -> { _uiState.value.emailError = it.value[0] }
                "password" -> { _uiState.value.passwordError = it.value[0] }
            }
        }
    }
}