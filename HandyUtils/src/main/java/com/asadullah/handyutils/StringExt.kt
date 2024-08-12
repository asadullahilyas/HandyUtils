package com.asadullah.handyutils

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.Base64

fun String?.isNullOrEmptyOrBlank() = this.isNullOrEmpty() || this.isBlank()

fun String?.isNeitherNullNorEmptyNorBlank() = this.isNullOrEmptyOrBlank().not()

fun String?.toNullIfEmptyOrBlank(): String? {
    return if (isNullOrEmptyOrBlank()) null else this
}

inline fun <T> String?.ifNeitherNullNorEmptyNorBlank(provider: (String) -> T?): T? {
    return if (isNeitherNullNorEmptyNorBlank()) {
        provider(this!!)
    } else null
}

fun String.capitalizeWords() = this.split(" ").joinToString(" ") { word -> word.replaceFirstChar { c -> c.uppercase() } }

fun String?.removeSpaces() = this?.replace(" ", "")

/**
 * Convert the given string into a string that only contains letters.
 */
fun String?.toLetters() = this?.filter { it.isLetter() }

/**
 * Convert the given string into a string that only contains digits.
 */
fun String?.toDigits() = this?.filter { it.isDigit() }

/**
 * Convert the given string into a string that only contains digits or points.
 * And example would be:
 *
 * "13.98 m/s".toDigitsWithPoint() would return "13.98"
 */
fun String?.toDigitsWithPoint() = this?.filter { it.isDigit() || it == '.' }

/**
 * Convert the given string into a string that only contains letters or digits.
 */
fun String?.toLettersOrDigits() = this?.filter { it.isLetterOrDigit() }

@RequiresApi(Build.VERSION_CODES.O)
fun String.decodeFromBase64String(): ByteArray {
    return Base64.getDecoder().decode(this)
}