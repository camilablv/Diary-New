package com.pchpsky.record.presentation.di

import com.pchpsky.record.domain.usecase.RecordInsulinUseCase
import com.pchpsky.record.presentation.insulin.RecordInsulinViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val recordsModule = module {
    viewModel { RecordInsulinViewModelImpl(get()) }
    factory { RecordInsulinUseCase(get()) }
}