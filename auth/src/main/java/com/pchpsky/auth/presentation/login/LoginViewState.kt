package com.pchpsky.auth.presentation.login


data class LoginViewState(
    var login: String = "",
    var password: String = "",
    var loading: Boolean = false,
    var sighInSuccessful: Boolean = false,
    var emailError: String = "",
    var passwordError: String = "",
    var authError: String = ""
)