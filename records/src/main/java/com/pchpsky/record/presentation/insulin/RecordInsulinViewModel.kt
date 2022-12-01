package com.pchpsky.record.presentation.insulin

import com.pchpsky.core.domain.model.Insulin
import kotlinx.coroutines.flow.StateFlow

interface RecordInsulinViewModel {
    val uiState: StateFlow<RecordInsulinViewState>
    fun incrementUnits()
    fun decrementUnits()
    fun setUnits(units: Double)
    suspend fun insulins()
    fun selectInsulin(insulin: Insulin)
    fun showInsulinMenu(drop: Boolean)
    fun showTimePicker(show: Boolean)
    fun showDatePicker(show: Boolean)
    fun selectTime(localTime: String)
    fun selectDate(localDate: String)
    fun addNote(note: String)
    fun noteTextFialdExpanded(value: Boolean)
}