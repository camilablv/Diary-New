package com.pchpsky.auth.data.network

import com.apollographql.apollo3.ApolloClient
import com.pchpsky.network.errors.NetworkErrorHandler
import org.koin.dsl.module

val authNetworkModule = module {
    single { provideAuthNetworkClient(get(), get()) }
}

private fun provideAuthNetworkClient(apolloClient: ApolloClient, errorHandler: NetworkErrorHandler) =
    AuthNetworkClient(apolloClient, errorHandler)