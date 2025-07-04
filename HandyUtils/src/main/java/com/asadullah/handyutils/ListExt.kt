package com.asadullah.handyutils

inline fun <reified T> List<T>.chunked(chunkSize: Int): List<List<T>> {
    if (chunkSize < 1) throw IllegalArgumentException("chunkSize must be greater than or equal to 1.")

    var cursor = 0

    val hasRemainder = this.size % chunkSize != 0

    val totalChunks = this.size / chunkSize + (if (hasRemainder) 1 else 0)

    return List(totalChunks) { i ->
        if (i < totalChunks - 1) {
            val slice = this.slice(cursor until (cursor + chunkSize))
            cursor += chunkSize
            slice
        } else {
            if (hasRemainder) {
                val slice = this.slice(cursor until (cursor + this.size % chunkSize))
                cursor += chunkSize
                slice
            } else {
                val slice = this.slice(cursor until (cursor + chunkSize))
                cursor += chunkSize
                slice
            }
        }
    }
}

inline fun <T> List<T>.runOnListIf(condition: Boolean, runIf: (thisList: List<T>) -> List<T>): List<T> {
    return if (condition) runIf(this) else this
}

inline fun <T> List<T>.runOnListIf(condition: Boolean, runIf: (thisList: List<T>) -> List<T>, runElse: (thisList: List<T>) -> List<T>): List<T> {
    return if (condition) runIf(this) else runElse(this)
}

fun <T> List<T>?.toNullIfEmpty(): List<T>? {
    return this?.ifEmpty {
        null
    }
}