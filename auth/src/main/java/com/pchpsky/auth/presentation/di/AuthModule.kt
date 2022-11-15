package com.pchpsky.auth.presentation.di

import com.pchpsky.auth.domain.usecase.LoginUseCase
import com.pchpsky.auth.presentation.login.LoginViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authModule = module {
    viewModel { LoginViewModelImpl(get()) }
    factory { LoginUseCase(get()) }
}