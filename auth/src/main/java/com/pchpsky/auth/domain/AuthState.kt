package com.pchpsky.auth.domain

sealed class AuthState {
    object SignupSuccessful : AuthState()
    object ServerError : AuthState()
    data class AuthenticationError(val message: String) : AuthState()
    data class ValidationError(val fields: Map<String, ArrayList<String>>) : AuthState()
}
