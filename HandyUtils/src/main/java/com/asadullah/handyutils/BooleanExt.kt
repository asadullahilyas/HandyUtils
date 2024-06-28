package com.asadullah.handyutils

fun <T> Boolean.executeForTrueNullForFalse(executable: () -> T): T? {
    return if (this) {
        executable()
    } else {
        null
    }
}