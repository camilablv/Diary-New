package com.pchpsky.record.data.repository

import com.pchpsky.record.data.repository.RecordInsulinRepositoryImpl
import com.pchpsky.record.domain.repository.RecordInsulinRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<RecordInsulinRepository> { RecordInsulinRepositoryImpl(get()) }
}