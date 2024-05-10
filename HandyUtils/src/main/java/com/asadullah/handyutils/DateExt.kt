package com.asadullah.handyutils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Date.format(format: String, locale: Locale = Locale.US): String {
    val simpleDateFormat = SimpleDateFormat(format, locale)
    return simpleDateFormat.format(this)
}