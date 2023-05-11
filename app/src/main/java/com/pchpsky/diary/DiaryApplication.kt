package com.pchpsky.diary

import android.app.Application
import com.pchpsky.auth.data.network.authNetworkModule
import com.pchpsky.auth.data.repository.authRepositoryModule
import com.pchpsky.auth.presentation.di.authModule
import com.pchpsky.network.di.networkModule
import com.pchpsky.record.data.network.recordsNetworkModule
import com.pchpsky.record.data.repository.repositoryModule
import com.pchpsky.record.presentation.di.recordsModule
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
                    recordsNetworkModule,
                    recordsModule,
                    authRepositoryModule,
                    authNetworkModule,
                    networkModule,
                    authModule
                )
            )
        }
    }
}