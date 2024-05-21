package com.asadullah.handyutils

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.Base64

fun String?.isNullOrEmptyOrBlank() = this.isNullOrEmpty() || this.isBlank()

fun String?.isNeitherNullNorEmptyNorBlank() = this.isNullOrEmptyOrBlank().not()

fun String?.toNullIfEmptyOrBlank(): String? {
    return if (isNullOrEmptyOrBlank()) null else this
}

inline fun String?.ifNeitherNullNorEmptyNorBlank(provider: (String) -> Unit): String? {
    return if (isNeitherNullNorEmptyNorBlank()) {
        provider(this!!)
        this
    } else null
}

fun String.capitalizeWords() = this.split(" ").joinToString(" ") { word -> word.replaceFirstChar { c -> c.uppercase() } }

fun String?.removeSpaces() = this?.replace(" ", "")

@RequiresApi(Build.VERSION_CODES.O)
fun String.decodeFromBase64String(): ByteArray {
    return Base64.getDecoder().decode(this)
}