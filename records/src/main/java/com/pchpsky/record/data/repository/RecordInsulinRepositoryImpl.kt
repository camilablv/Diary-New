package com.pchpsky.record.data.repository

import arrow.core.Either
import com.pchpsky.InsulinsQuery
import com.pchpsky.network.errors.NetworkError
import com.pchpsky.record.data.network.NetworkClient
import com.pchpsky.record.domain.repository.RecordInsulinRepository

class RecordInsulinRepositoryImpl(private val networkClient: NetworkClient)
    : RecordInsulinRepository
{
    override suspend fun insulins(): Either<NetworkError, InsulinsQuery.Data> {
        return networkClient.insulins()
    }
}