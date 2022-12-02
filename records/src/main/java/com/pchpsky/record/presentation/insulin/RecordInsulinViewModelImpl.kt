package com.pchpsky.record.presentation.insulin

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.pchpsky.core.domain.model.Insulin
import com.pchpsky.record.domain.usecase.RecordInsulinUseCase
import com.pchpsky.record.utils.insulins
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RecordInsulinViewModelImpl(
    private val useCase: RecordInsulinUseCase
) : ViewModel(), RecordInsulinViewModel {
    private var _uiState = MutableStateFlow(RecordInsulinViewState())
    override val uiState: StateFlow<RecordInsulinViewState> = _uiState

    val noteText = mutableStateOf("Once we have the width" +
            " of our text field boundaries and we know how to calculate the width of our " +
            "text, it’s not that complicated to find desired font size. We are going to compare " +
            "those two values, and we will continue to decrease our default font size and" +
            " recalculate our instrinsics, until our text width becomes smaller than the text" +
            " field’s width.")

    override fun incrementUnits() {
        val units = _uiState.value.units
        if (units == 99.0) return
        _uiState.value = _uiState.value.copy(units = units + 1)
    }

    override fun decrementUnits() {
        val units = _uiState.value.units
        if (units == 1.0) return
        _uiState.value = _uiState.value.copy(units = units - 1)
    }

    override fun setUnits(units: Double) {
        if (units < 1.0 || units > 100.0) return
        else _uiState.value = _uiState.value.copy(units = units, unitsInputError = "")
    }

    override suspend fun insulins() {
        Log.d("debugInsulin", "insulins")
        _uiState.value = _uiState.value.copy(loading = true)
        useCase.insulins().fold(
            ifLeft = {
                Log.d("debugInsulin", "returns left")
            },
            ifRight = {
                Log.d("debugInsulin", "returns right")
                val insulins = it.insulins()
                _uiState.value = _uiState.value.copy(insulins = insulins!!, selectedInsulin = insulins.first(), loading = false)
            }
        )
    }

    override fun selectInsulin(insulin: Insulin) {
        _uiState.value = _uiState.value.copy(showInsulinMenu = false, selectedInsulin = insulin)
    }

    override fun showInsulinMenu(show: Boolean) {
        _uiState.value = _uiState.value.copy(showInsulinMenu = show)
    }

    override fun showTimePicker(show: Boolean) {
        _uiState.value = _uiState.value.copy(showTimePicker = show)
    }

    override fun showDatePicker(show: Boolean) {
        _uiState.value = _uiState.value.copy(showDatePicker = show)
    }

    override fun selectTime(localTime: String) {
        _uiState.value = _uiState.value.copy(time = localTime)
    }

    override fun selectDate(localDate: String) {
        _uiState.value = _uiState.value.copy(date = TODO())
    }

    override fun addNote(note: String) {
        _uiState.value = _uiState.value.copy(note = note)
    }

    override fun noteTextFialdExpanded(value: Boolean) {
        _uiState.value = _uiState.value.copy(noteTextFieldExpanded = value)
    }
}