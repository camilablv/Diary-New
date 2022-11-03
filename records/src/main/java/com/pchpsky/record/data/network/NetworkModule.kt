package com.pchpsky.record.data.network

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import com.pchpsky.network.errors.NetworkErrorHandler
import com.pchpsky.network.interceptor.AuthorizationInterceptor
import com.pchpsky.network.token.TokenStore
import okhttp3.OkHttpClient
import org.koin.dsl.module

val networkModule = module {
    single { provideApolloClient() }
    single { provideNetworkClient(get(), get()) }
}

fun provideApolloClient(): ApolloClient {
    val okHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(AuthorizationInterceptor(TokenStore()))
        .build()
    return ApolloClient
        .Builder()
        .serverUrl("https://pchpsky-diary.fly.dev/graph")
        .okHttpClient(okHttpClient)
        .build()
}

fun provideNetworkClient(apolloClient: ApolloClient, errorHandler: NetworkErrorHandler) =
    NetworkClient(apolloClient, errorHandler)