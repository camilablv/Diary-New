package com.pchpsky.auth.domain.repository

import arrow.core.Either
import com.pchpsky.CreateSessionMutation
import com.pchpsky.network.errors.NetworkError

interface LoginRepository {
    suspend fun login(login: String, password: String): Either<NetworkError, CreateSessionMutation.Data?>
}