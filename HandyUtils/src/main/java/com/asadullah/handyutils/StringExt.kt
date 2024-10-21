package com.asadullah.handyutils

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.Base64

/**
 * @param strict: By default strict is set to true. If you set it to false, strings like `"null"` will also return true.
 */
fun String?.isNullOrEmptyOrBlank(strict: Boolean = true) = this.isNullOrEmpty() || this.isBlank() || (strict.not() && "null".equals(this, true))

/**
 * @param strict: By default strict is set to true. If you set it to false, strings like `"null"` will return false.
 */
fun String?.isNeitherNullNorEmptyNorBlank(strict: Boolean = true) = this.isNullOrEmptyOrBlank(strict).not()

/**
 * @param strict: By default strict is set to true. If you set it to false, strings like `"null"` will be converted to null.
 */
fun String?.toNullIfEmptyOrBlank(strict: Boolean = true): String? {
    return if (isNullOrEmptyOrBlank(strict)) null else this
}

/**
 * @param strict: By default strict is set to true. If you set it to false, strings like `"null"` will be considered and returned as null.
 */
inline fun <T> String?.ifNeitherNullNorEmptyNorBlank(provider: (String) -> T?, strict: Boolean = true): T? {
    return if (isNeitherNullNorEmptyNorBlank(strict)) {
        provider(this!!)
    } else null
}

fun String.capitalizeWords() = this.lowercase().split(" ").joinToString(" ") { word -> word.replaceFirstChar { c -> c.uppercase() } }

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