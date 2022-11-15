package com.pchpsky.auth.presentation.login


data class LoginViewState(
    var login: String = "",
    var password: String = "",
    var loading: Boolean = false,
    var sighInSuccessful: Boolean = false,
    var emailError: String? = null,
    var passwordError: String? = null,
    var authError: String = ""
)