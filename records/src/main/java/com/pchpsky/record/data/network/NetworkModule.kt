package com.pchpsky.record.data.network

import com.apollographql.apollo3.ApolloClient
import com.pchpsky.network.errors.NetworkErrorHandler
import org.koin.dsl.module

val recordsNetworkModule = module {
    single { provideRecordsNetworkClient(get(), get()) }
}

private fun provideRecordsNetworkClient(apolloClient: ApolloClient, errorHandler: NetworkErrorHandler) =
    NetworkClient(apolloClient, errorHandler)

