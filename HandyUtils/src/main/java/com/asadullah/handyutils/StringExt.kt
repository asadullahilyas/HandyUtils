package com.asadullah.handyutils

import android.icu.text.DecimalFormatSymbols
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.Charset
import java.util.Base64
import java.util.Locale

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
inline fun <T> String?.ifNeitherNullNorEmptyNorBlank(strict: Boolean = true, provider: (String) -> T?): T? {
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
 * An example would be:
 *
 * "13.98 m/s".toDigitsWithPoint() would return "13.98"
 */
fun String?.toDigitsWithPoint() = this?.filter { it.isDigit() || it == '.' }

/**
 * Convert the given string into a string that only contains digits or the
 * decimal separator, depending upon provided Locale.
 * An example would be:
 *
 * For Locale `en_PK`
 *
 * "13.98 m/s".toDigitsWithDecimalSeparator() would return "13.98"
 *
 * For Locale `es`
 *
 * "13,98 m/s".toDigitsWithDecimalSeparator() would return "13,98"
 *
 * For more info, visit [here](https://www.localeplanet.com/java/)
 *
 * [https://www.localeplanet.com/java/](https://www.localeplanet.com/java/)
 */
@RequiresApi(Build.VERSION_CODES.N)
fun String?.toDigitsWithDecimalSeparator(locale: Locale = Locale.getDefault()) = this?.filter {
    it.isDigit() || it == DecimalFormatSymbols.getInstance(locale).decimalSeparator
}

/**
 * Convert the given string into a string that only contains digits or the
 * group separator, depending upon provided Locale.
 * An example would be:
 *
 * For Locale `en_PK`
 *
 * "7,000,000.50".toDigitsWithGroupSeparator() would return "7,000,00050"
 *
 * For Locale `es`
 *
 * "7.000.000,50".toDigitsWithGroupSeparator() would return "7.000.00050"
 *
 * For more info, visit [here](https://www.localeplanet.com/java/)
 *
 * [https://www.localeplanet.com/java/](https://www.localeplanet.com/java/)
 */
@RequiresApi(Build.VERSION_CODES.N)
fun String?.toDigitsWithGroupSeparator(locale: Locale = Locale.getDefault()) = this?.filter {
    it.isDigit() || it == DecimalFormatSymbols.getInstance(locale).groupingSeparator
}

/**
 * Convert the given string into a string that only contains digits or the
 * monetary decimal separator, depending upon provided Locale.
 * An example would be:
 *
 * For Locale `en_PK`
 *
 * "Rs: 7,000,000.50".toDigitsWithMonetaryDecimalSeparator() would return "7000000.50"
 *
 * For Locale `es`
 *
 * "€: 7.000.000,50".toDigitsWithMonetaryDecimalSeparator() would return "7000000,50"
 *
 * For more info, visit [here](https://www.localeplanet.com/java/)
 *
 * [https://www.localeplanet.com/java/](https://www.localeplanet.com/java/)
 */
@RequiresApi(Build.VERSION_CODES.N)
fun String?.toDigitsWithMonetaryDecimalSeparator(locale: Locale = Locale.getDefault()) = this?.filter {
    it.isDigit() || it == DecimalFormatSymbols.getInstance(locale).monetaryDecimalSeparator
}

/**
 * Convert the given string into a string that only contains digits or the
 * monetary group separator, depending upon provided Locale.
 * An example would be:
 *
 * For Locale `en_PK`
 *
 * "Rs: 7,000,000.50".toDigitsWithMonetaryGroupSeparator() would return "7,000,00050"
 *
 * For Locale `es`
 *
 * "€: 7.000.000,50".toDigitsWithMonetaryGroupSeparator() would return "7.000.00050"
 *
 * For more info, visit [here](https://www.localeplanet.com/java/)
 *
 * [https://www.localeplanet.com/java/](https://www.localeplanet.com/java/)
 */
@RequiresApi(Build.VERSION_CODES.N)
fun String?.toDigitsWithMonetaryGroupSeparator(locale: Locale = Locale.getDefault()) = this?.filter {
    it.isDigit() || it == DecimalFormatSymbols.getInstance(locale).monetaryGroupingSeparator
}

/**
 * Convert the given string into a string that only contains digits or the
 * monetary group separator, depending upon provided Locale.
 * An example would be:
 *
 * For Locale `en_PK`
 *
 * "Rs: 7,000,000.50".toDigitsWithMonetaryDecimalGroupSeparator() would return "7,000,000.50"
 *
 * For Locale `es`
 *
 * "€: 7.000.000,50".toDigitsWithMonetaryDecimalGroupSeparator() would return "7.000.000,50"
 *
 * For more info, visit [here](https://www.localeplanet.com/java/)
 *
 * [https://www.localeplanet.com/java/](https://www.localeplanet.com/java/)
 */
@RequiresApi(Build.VERSION_CODES.N)
fun String?.toDigitsWithMonetaryDecimalGroupSeparator(locale: Locale = Locale.getDefault()) = this?.filter {
    val formatter = DecimalFormatSymbols.getInstance(locale)
    it.isDigit()
            || it == formatter.monetaryDecimalSeparator
            || it == formatter.monetaryGroupingSeparator
}

/**
 * Convert the given string into a string that only contains letters or digits.
 */
fun String?.toLettersOrDigits() = this?.filter { it.isLetterOrDigit() }

@RequiresApi(Build.VERSION_CODES.O)
fun String.decodeFromBase64String(): ByteArray {
    return Base64.getDecoder().decode(this)
}

fun String.urlEncode(charset: Charset = Charsets.UTF_8): String {
    return if (SDKHelper.hasAndroid33()) URLEncoder.encode(this, charset) else Uri.encode(this)
}

fun String.urlDecode(charset: Charset = Charsets.UTF_8): String {
    return if (SDKHelper.hasAndroid33()) URLDecoder.decode(this, charset) else Uri.decode(this)
}