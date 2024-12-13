package com.asadullah.handyutils

import android.icu.text.DecimalFormatSymbols
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import java.util.Locale

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class InstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.asadullah.handyutils.test", appContext.packageName)
    }
    
    

    @Test
    fun testingToDigitsWithDecimalSeparatorWithDefaultLocale() {
        val expected = buildString {
            append("13")
            append(DecimalFormatSymbols.getInstance().decimalSeparator)
            append("98")
        }
        assertEquals(expected, "13.98 m/s".toDigitsWithDecimalSeparator())
    }

    @Test
    fun testingToDigitsWithDecimalSeparatorWithEnglishPakistanLocale() {
        assertEquals("13.98", "13.98 m/s".toDigitsWithDecimalSeparator(Locale("en", "PK")))
    }

    @Test
    fun testingToDigitsWithDecimalSeparatorWithSpanishLocale() {
        assertEquals("13,98", "13,98 m/s".toDigitsWithDecimalSeparator(Locale("es")))
    }

    
    
    @Test
    fun testingToDigitsWithGroupSeparatorWithDefaultLocale() {
        val expected = buildString {
            append("7")
            append(DecimalFormatSymbols.getInstance().groupingSeparator)
            append("000")
            append(DecimalFormatSymbols.getInstance().groupingSeparator)
            append("000")
            append("50")
        }
        assertEquals(expected, "7,000,000.50".toDigitsWithGroupSeparator())
    }

    @Test
    fun testingToDigitsWithGroupSeparatorWithEnglishPakistanLocale() {
        assertEquals("7,000,00050", "7,000,000.50".toDigitsWithGroupSeparator(Locale("en", "PK")))
    }

    @Test
    fun testingToDigitsWithGroupSeparatorWithSpanishLocale() {
        assertEquals("7.000.00050", "7.000.000,50".toDigitsWithGroupSeparator(Locale("es")))
    }

    
    
    @Test
    fun testingToDigitsWithMonetaryDecimalSeparatorWithDefaultLocale() {
        val expected = buildString {
            append("7")
            append("000")
            append("000")
            append(DecimalFormatSymbols.getInstance().monetaryDecimalSeparator)
            append("50")
        }
        assertEquals(expected, "Rs: 7,000,000.50".toDigitsWithMonetaryDecimalSeparator())
    }

    @Test
    fun testingToDigitsWithMonetaryDecimalSeparatorWithEnglishPakistanLocale() {
        assertEquals("7000000.50", "Rs: 7,000,000.50".toDigitsWithMonetaryDecimalSeparator(Locale("en", "PK")))
    }

    @Test
    fun testingToDigitsWithMonetaryDecimalSeparatorWithSpanishLocale() {
        assertEquals("7000000,50", "€: 7.000.000,50".toDigitsWithMonetaryDecimalSeparator(Locale("es")))
    }



    @Test
    fun testingToDigitsWithMonetaryGroupSeparatorWithDefaultLocale() {
        val expected = buildString {
            append("7")
            append(DecimalFormatSymbols.getInstance().monetaryGroupingSeparator)
            append("000")
            append(DecimalFormatSymbols.getInstance().monetaryGroupingSeparator)
            append("000")
            append("50")
        }
        assertEquals(expected, "Rs: 7,000,000.50".toDigitsWithMonetaryGroupSeparator())
    }

    @Test
    fun testingToDigitsWithMonetaryGroupSeparatorWithEnglishPakistanLocale() {
        assertEquals("7,000,00050", "Rs: 7,000,000.50".toDigitsWithMonetaryGroupSeparator(Locale("en", "PK")))
    }

    @Test
    fun testingToDigitsWithMonetaryGroupSeparatorWithSpanishLocale() {
        assertEquals("7.000.00050", "€: 7.000.000,50".toDigitsWithMonetaryGroupSeparator(Locale("es")))
    }
    
    

    @Test
    fun testingToDigitsWithMonetaryDecimalAndGroupSeparatorWithDefaultLocale() {
        val expected = buildString {
            append("7")
            append(DecimalFormatSymbols.getInstance().monetaryGroupingSeparator)
            append("000")
            append(DecimalFormatSymbols.getInstance().monetaryGroupingSeparator)
            append("000")
            append(DecimalFormatSymbols.getInstance().monetaryDecimalSeparator)
            append("50")
        }
        assertEquals(expected, "Rs: 7,000,000.50".toDigitsWithMonetaryDecimalGroupSeparator())
    }

    @Test
    fun testingToDigitsWithMonetaryDecimalAndGroupSeparatorWithEnglishPakistanLocale() {
        assertEquals("7,000,000.50", "Rs: 7,000,000.50".toDigitsWithMonetaryDecimalGroupSeparator(Locale("en", "PK")))
    }

    @Test
    fun testingToDigitsWithMonetaryDecimalAndGroupSeparatorWithSpanishLocale() {
        assertEquals("7.000.000,50", "€: 7.000.000,50".toDigitsWithMonetaryDecimalGroupSeparator(Locale("es")))
    }
}