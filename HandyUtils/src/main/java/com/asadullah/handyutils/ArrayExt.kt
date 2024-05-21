package com.asadullah.handyutils

inline fun <reified T> Array<T>.chunked(chunkSize: Int): Array<Array<out T>> {
    if (chunkSize < 1) throw IllegalArgumentException("chunkSize must be greater than or equal to 1.")

    var cursor = 0

    val hasRemainder = this.size % chunkSize != 0

    val totalChunks = this.size / chunkSize + (if (hasRemainder) 1 else 0)

    return Array(totalChunks) { i ->
        if (i < totalChunks - 1) {
            val slice = this.sliceArray(cursor until (cursor + chunkSize))
            cursor += chunkSize
            slice
        } else {
            if (hasRemainder) {
                val slice = this.sliceArray(cursor until (cursor + this.size % chunkSize))
                cursor += chunkSize
                slice
            } else {
                val slice = this.sliceArray(cursor until (cursor + chunkSize))
                cursor += chunkSize
                slice
            }
        }
    }
}