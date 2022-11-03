package com.pchpsky.diary

import android.app.Application
import com.pchpsky.record.data.network.networkModule
import com.pchpsky.record.data.repository.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class DiaryApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@DiaryApplication)
            modules(
                listOf(
                    repositoryModule,
                    networkModule
                )
            )
        }
    }
}