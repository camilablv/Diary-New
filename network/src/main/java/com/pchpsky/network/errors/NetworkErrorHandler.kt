package com.pchpsky.network.errors

import arrow.core.Either
import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.api.Error
import com.apollographql.apollo3.api.Operation
import com.apollographql.apollo3.exception.ApolloHttpException

class NetworkErrorHandler {

    suspend fun <T: Operation.Data>withErrorHandler(request: suspend () -> ApolloResponse<T>): Either<NetworkError, T> {
        try {
            val response = request.invoke()
            if (response.errors != null) {
                val error = parse(response.errors!!.first())
                return Either.Left(error)
            }
            return Either.Right(response.data!!)
        } catch (exception: ApolloHttpException) {
            return Either.Left(NetworkError.ServerError)
        }
    }

    private fun parse(error: Error): NetworkError {
        return when (error.nonStandardFields?.get("code")?.toString()?.toInt()) {
            422 -> {
                var fields = error.nonStandardFields?.get("fields") as Map<String, ArrayList<String>>
                fields = fields.entries.associate {
                    it.key to it.value
                }
                NetworkError.ValidationError(fields)
            }
            401 -> { NetworkError.AuthenticationError(error.message) }
            else -> { NetworkError.ServerError }
        }
    }
}