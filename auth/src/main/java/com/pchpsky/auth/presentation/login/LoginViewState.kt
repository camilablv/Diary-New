package com.pchpsky.auth.presentation.login


data class LoginViewState(
    var email: String = "",
    var password: String = "",
    var loading: Boolean = false,
    var sighIn: Boolean = false,
    var emailError: String = "",
    var passwordError: String = "",
)