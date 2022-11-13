package com.pchpsky.auth.data.repository

import com.pchpsky.auth.domain.repository.LoginRepository
import org.koin.dsl.module

val authRepositoryModule = module {
    factory<LoginRepository> { LoginRepositoryImpl(get()) }
}