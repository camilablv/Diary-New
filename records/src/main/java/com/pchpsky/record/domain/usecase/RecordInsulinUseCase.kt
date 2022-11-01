package com.pchpsky.record.domain.usecase

import android.util.Log
import arrow.core.Either
import com.pchpsky.InsulinsQuery
import com.pchpsky.network.errors.NetworkError
import com.pchpsky.record.domain.repository.RecordInsulinRepository

class RecordInsulinUseCase(
    private val repository: RecordInsulinRepository
) {
    suspend fun insulins(): Either<NetworkError, InsulinsQuery.Data> {
        return repository.insulins()
    }
}