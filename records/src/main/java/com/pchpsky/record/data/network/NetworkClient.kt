package com.pchpsky.record.data.network

import arrow.core.Either
import com.apollographql.apollo3.ApolloClient
import com.pchpsky.InsulinsQuery
import com.pchpsky.network.errors.NetworkError
import com.pchpsky.network.errors.NetworkErrorHandler

class NetworkClient(
    private val apolloClient: ApolloClient,
    private val errorsHandler: NetworkErrorHandler
) {
    suspend fun insulins(): Either<NetworkError, InsulinsQuery.Data> {
        return errorsHandler.withErrorHandler {
            return@withErrorHandler apolloClient.query(InsulinsQuery()).execute()
        }
    }
}