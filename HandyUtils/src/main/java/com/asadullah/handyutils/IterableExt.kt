package com.asadullah.handyutils

inline fun <T, R> Iterable<T>.findWithObject(predicate: (T) -> R?): R {
    for (item in this) {
        val r = predicate(item)
        if (r != null) {
            return r
        }
    }
    throw Exception("Item not found")
}

inline fun <T, R> Iterable<T>.findWithObjectOrNull(predicate: (T) -> R?): R? {
    return try {
        findWithObject(predicate)
    } catch (e: Exception) {
        null
    }
}

inline fun <T> Iterable<T>.runIf(condition: Boolean, runIf: (thisList: Iterable<T>) -> Iterable<T>): Iterable<T> {
    return if (condition) runIf(this) else this
}

inline fun <T> Iterable<T>.runIf(condition: Boolean, runIf: (thisList: Iterable<T>) -> Iterable<T>, runElse: (thisList: Iterable<T>) -> Iterable<T>): Iterable<T> {
    return if (condition) runIf(this) else runElse(this)
}