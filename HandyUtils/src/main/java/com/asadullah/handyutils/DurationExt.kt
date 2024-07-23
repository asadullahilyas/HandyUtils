package com.asadullah.handyutils

import kotlin.time.Duration

/**
 * This function will convert [kotlin.time.Duration] into readable string.
 *
 * Following are the examples of returned String:
 *
 *  `286 millis`
 *
 * `3 secs 286 millis`
 *
 * `17 mins 3 secs 286 millis`
 *
 * `1 hour 17 mins 3 secs 286 millis`
 *
 * `27 days 1 hour 17 mins 3 secs 286 millis`
 *
 * `8 months 27 days 1 hour 17 mins 3 secs 286 millis`
 *
 * `3 years 8 months 27 days 1 hour 17 mins 3 secs 286 millis`
 */
fun Duration.toReadableDuration(): String {
    return buildString {
        when {
            inWholeMilliseconds < 1000L -> {
                append("$inWholeMilliseconds millis")
            }

            inWholeSeconds < 60L -> {
                append("$inWholeSeconds sec${if (inWholeSeconds == 1L) "" else "s"}")
                append(" ")
                append("${inWholeMilliseconds % 1000} millis")
            }

            inWholeMinutes < 60L -> {
                append("$inWholeMinutes min${if (inWholeMinutes == 1L) "" else "s"}")
                append(" ")
                append(with(inWholeSeconds % 60) { "$this sec${if (this == 1L) "" else "s"}" })
                append(" ")
                append("${inWholeMilliseconds % 1000} millis")
            }

            inWholeHours < 24L -> {
                append("$inWholeHours hour${if (inWholeHours == 1L) "" else "s"}")
                append(" ")
                append(with(inWholeMinutes % 60) { "$this min${if (this == 1L) "" else "s"}" })
                append(" ")
                append(with(inWholeSeconds % 60) { "$this sec${if (this == 1L) "" else "s"}" })
                append(" ")
                append("${inWholeMilliseconds % 1000} millis")
            }

            inWholeDays < 30L -> {
                append("$inWholeDays day${if (inWholeDays == 1L) "" else "s"}")
                append(" ")
                append(with(inWholeHours % 24) { "$this hour${if (this == 1L) "" else "s"}" })
                append(" ")
                append(with(inWholeMinutes % 60) { "$this min${if (this == 1L) "" else "s"}" })
                append(" ")
                append(with(inWholeSeconds % 60) { "$this sec${if (this == 1L) "" else "s"}" })
                append(" ")
                append("${inWholeMilliseconds % 1000} millis")
            }

            inWholeDays < 365L -> {
                val months = inWholeDays / 30L
                append("$months month${if (months == 1L) "" else "s"}")
                append(" ")
                append(with(inWholeDays % 30) { "$this day${if (this == 1L) "" else "s"}" })
                append(" ")
                append(with(inWholeHours % 24) { "$this hour${if (this == 1L) "" else "s"}" })
                append(" ")
                append(with(inWholeMinutes % 60) { "$this min${if (this == 1L) "" else "s"}" })
                append(" ")
                append(with(inWholeSeconds % 60) { "$this sec${if (this == 1L) "" else "s"}" })
                append(" ")
                append("${inWholeMilliseconds % 1000} millis")
            }

            else -> {
                val years = inWholeDays / 365L
                val restOfTheDaysInThisYear = inWholeDays % 365
                val months = restOfTheDaysInThisYear / 30L
                append("$years year${if (years == 1L) "" else "s"}")
                append(" ")
                append("$months month${if (months == 1L) "" else "s"}")
                append(" ")
                append(with(inWholeDays % 30) { "$this day${if (this == 1L) "" else "s"}" })
                append(" ")
                append(with(inWholeHours % 24) { "$this hour${if (this == 1L) "" else "s"}" })
                append(" ")
                append(with(inWholeMinutes % 60) { "$this min${if (this == 1L) "" else "s"}" })
                append(" ")
                append(with(inWholeSeconds % 60) { "$this sec${if (this == 1L) "" else "s"}" })
                append(" ")
                append("${inWholeMilliseconds % 1000} millis")
            }
        }
    }
}