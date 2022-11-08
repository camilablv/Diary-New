package com.pchpsky.record.utils

import com.pchpsky.InsulinsQuery
import com.pchpsky.core.domain.model.Insulin

fun InsulinsQuery.Data.insulins(): List<Insulin>? {
    return settings?.insulins?.map {
        Insulin(
            id = it?.id!!,
            color = it.color!!,
            name = it.name!!
        )
    }
}