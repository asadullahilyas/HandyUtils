package com.asadullah.handyutils

import java.math.RoundingMode
import java.text.DecimalFormat

fun Double.toDecimalPoints(points: Int, roundingMode: RoundingMode = RoundingMode.UNNECESSARY): String {
    val decimalFormat = DecimalFormat("0." + buildString { repeat(points) { append("0") } })
    decimalFormat.roundingMode = roundingMode
    return decimalFormat.format(this)
}