package com.pchpsky.record.data.repository

import arrow.core.Either
import com.pchpsky.record.domain.repository.RecordInsulinRepository

class RecordInsulinRepositoryImpl(private val networkClient: NetworkClient)
    : RecordInsulinRepository
{
    override suspend fun insulins(): Either<NetworkError, InsulinsQuery.Data> {
        return networkClient.insulins()
    }
}