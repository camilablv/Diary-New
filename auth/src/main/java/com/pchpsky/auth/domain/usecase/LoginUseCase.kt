package com.pchpsky.auth.domain.usecase

import com.pchpsky.auth.domain.repository.LoginRepository
import com.pchpsky.auth.domain.AuthState
import com.pchpsky.network.errors.NetworkError

class LoginUseCase(private val repository: LoginRepository) {

    suspend fun login(login: String, password: String): AuthState {
        return repository.login(login, password).fold(
            ifLeft = { networkError ->
                when(networkError) {
                    is NetworkError.ServerError -> { AuthState.ServerError }
                    is NetworkError.AuthenticationError -> {
                        AuthState.AuthenticationError(networkError.message)
                    }
                    is NetworkError.ValidationError -> {
                        AuthState.ValidationError(networkError.fields)
                    }
                }
            },
            ifRight = {
                AuthState.SignupSuccessful
            }
        ).also { it }
    }
}