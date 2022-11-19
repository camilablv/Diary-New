package com.pchpsky.record.presentation.insulin

import com.pchpsky.core.domain.model.Insulin
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
    val time: String = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm")),
    val date: String = LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM")),
    val note: String = "",
    val noteTextExpanded: Boolean = false,
    val loading: Boolean = false
)