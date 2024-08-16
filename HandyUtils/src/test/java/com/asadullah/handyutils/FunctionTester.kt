package com.asadullah.handyutils

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class FunctionTester {
    @Test
    fun test() {
        val resultList = (0 .. 20).toList()
            .runIf(
                condition = false,
                runIf = { it.filter { it % 2 == 0 } },
                runElse = { it.filter { it % 2 != 0 } }
            )
            .filter { it > 10 }
            .also { println(it) }
    }
}