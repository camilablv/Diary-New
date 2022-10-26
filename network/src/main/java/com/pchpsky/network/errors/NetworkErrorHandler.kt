package com.pchpsky.network.errors

import arrow.core.Either
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloHttpException

class NetworkErrorHandler {

    suspend fun <T>withErrorHandler(request: suspend () -> Response<T>): Either<NetworkError, T> {
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
        val code = error.customAttributes["code"].toString().toInt()
        return when (code) {
            422 -> {
                var fields = error.customAttributes["fields"] as Map<String, ArrayList<String>>
                fields = fields.entries.map {
                    it.key to it.value
                }.toMap()
                NetworkError.ValidationError(fields)
            }
            401 -> { NetworkError.AuthenticationError(error.message) }
            else -> { NetworkError.ServerError }
        }
    }
}