package com.pchpsky.record.presentation.insulin

import com.pchpsky.core.domain.model.Date
import com.pchpsky.core.domain.model.Insulin
import com.pchpsky.core.utils.extentions.currentDay
import com.pchpsky.core.utils.extentions.currentMonth
import com.pchpsky.core.utils.extentions.currentTime
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

data class RecordInsulinViewState(
    val units: Double = 1.0,
    val selectedInsulin: Insulin? = null,
    val insulins: List<Insulin> = listOf(),
    val unitsInputError: String = "",
    val showInsulinMenu: Boolean = false,
    val showTimePicker: Boolean = false,
    val showDatePicker: Boolean = false,
    val time: String = currentTime(),
    val date: Date = Date(currentDay(), currentMonth()),
    val note: String = "",
    val noteTextFieldExpanded: Boolean = false,
    val loading: Boolean = false
)