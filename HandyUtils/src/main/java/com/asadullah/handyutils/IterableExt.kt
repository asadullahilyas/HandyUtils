package com.asadullah.handyutils

fun <T, R> Iterable<T>.findWithObject(predicate: (T) -> R?): R {
    for (item in this) {
        val r = predicate(item)
        if (r != null) {
            return r
        }
    }
    throw Exception("Item not found")
}

fun <T, R> Iterable<T>.findWithObjectOrNull(predicate: (T) -> R?): R? {
    return try {
        findWithObject(predicate)
    } catch (e: Exception) {
        null
    }
}