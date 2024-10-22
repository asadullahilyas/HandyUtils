package com.asadullah.handyutils

import org.junit.Assert
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

    @Test
    fun `String null or empty or blank with null`() {
        val str: String? = null
        assertEquals(true, str.isNullOrEmptyOrBlank())
    }

    @Test
    fun `String null or empty or blank with empty`() {
        val str: String = ""
        assertEquals(true, str.isNullOrEmptyOrBlank())
    }

    @Test
    fun `String null or empty or blank with blank`() {
        val str: String = "  "
        assertEquals(true, str.isNullOrEmptyOrBlank())
    }

    @Test
    fun `String null or empty or blank with null string but strict true`() {
        val str: String = "null"
        assertEquals(false, str.isNullOrEmptyOrBlank())
    }

    @Test
    fun `String null or empty or blank with null string but strict false`() {
        val str: String = "null"
        assertEquals(true, str.isNullOrEmptyOrBlank(false))
    }

    @Test
    fun `String null or empty or blank with strict false with different case of null`() {
        val str: String = "Null"
        assertEquals(true, str.isNullOrEmptyOrBlank(false))
    }

    @Test
    fun `String null or empty or blank with actual string`() {
        val str: String = "Asadullah"
        assertEquals(false, str.isNullOrEmptyOrBlank())
    }

    @Test
    fun `String neither null nor empty nor blank with null string but strict true`() {
        val str: String = "null"
        assertEquals(true, str.isNeitherNullNorEmptyNorBlank())
    }

    @Test
    fun `String neither null nor empty nor blank with null string but strict false`() {
        val str: String = "null"
        assertEquals(false, str.isNeitherNullNorEmptyNorBlank(false))
    }

    @Test
    fun `String if neither null nor empty nor blank with null string`() {
        val str: String = "null"
        assertEquals("null", str.ifNeitherNullNorEmptyNorBlank {
            it
        })
    }

    @Test
    fun `String if neither null nor empty nor blank with null string but strict false`() {
        val str: String = "null"
        assertEquals(null, str.ifNeitherNullNorEmptyNorBlank(false) {
            it
        })
    }
}