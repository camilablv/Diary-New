package com.pchpsky.record.domain.repository

import arrow.core.Either
import com.pchpsky.InsulinsQuery
import com.pchpsky.network.errors.NetworkError

interface RecordInsulinRepository {
    suspend fun insulins(): Either<NetworkError, InsulinsQuery.Data>
}