package com.pchpsky.auth.data.repository

import arrow.core.Either
import com.pchpsky.CreateSessionMutation
import com.pchpsky.auth.data.network.AuthNetworkClient
import com.pchpsky.auth.domain.repository.LoginRepository
import com.pchpsky.network.errors.NetworkError
import com.pchpsky.network.token.TokenStore

class LoginRepositoryImpl(private val networkClient: AuthNetworkClient) : LoginRepository {
    override suspend fun login(
        login: String,
        password: String
    ): Either<NetworkError, CreateSessionMutation.Data?> {
        return networkClient.login(login, password).map {
            it.session?.token?.let { token -> saveToken(token) }
            it
        }
    }

    private suspend fun saveToken(token: String) {
        TokenStore().token = token
    }
}