package com.pchpsky.auth.data.network

import arrow.core.Either
import com.apollographql.apollo3.ApolloClient
import com.pchpsky.CreateSessionMutation
import com.pchpsky.CreateUserMutation
import com.pchpsky.network.errors.NetworkError
import com.pchpsky.network.errors.NetworkErrorHandler

class AuthNetworkClient(
    private val apolloClient: ApolloClient,
    private val errorHandler: NetworkErrorHandler
    ) {
    suspend fun login(
        email: String,
        password: String
    ): Either<NetworkError, CreateSessionMutation.Data> {
        return errorHandler.withErrorHandler {
            return@withErrorHandler apolloClient
                .mutation(CreateSessionMutation(email, password)).execute()
        }
    }

    suspend fun createUser(
        email: String,
        password: String
    ): Either<NetworkError, CreateUserMutation.Data> {
        return errorHandler.withErrorHandler {
            return@withErrorHandler apolloClient
                .mutation(CreateUserMutation(email, password)).execute()
        }
    }
}