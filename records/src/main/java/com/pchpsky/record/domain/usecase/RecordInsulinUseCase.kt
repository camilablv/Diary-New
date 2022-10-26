package com.pchpsky.record.domain.usecase

import android.util.Log
import com.pchpsky.record.domain.repository.RecordInsulinRepository

class RecordInsulinUseCase(
    private val repository: RecordInsulinRepository
) {
    suspend fun insulins() {
        repository.insulins().fold(
            ifLeft = {
                Log.d("debugInsulin", "returns left")
            },
            ifRight = {
                Log.d("debugInsulin", "returns right")
                val insulins = it.insulins()
//                _uiState.value = _uiState.value.copy(insulins = insulins!!, selectedInsulin = insulins.first(), loading = false)
            }
        )
    }
}