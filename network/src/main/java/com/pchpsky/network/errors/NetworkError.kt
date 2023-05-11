package com.pchpsky.network.errors

sealed class NetworkError {
    object ServerError : NetworkError()
    data class AuthenticationError(val message: String) : NetworkError()
    data class ValidationError(val fields: Map<String, ArrayList<String>>) : NetworkError()
}