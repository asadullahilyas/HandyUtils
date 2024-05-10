package com.asadullah.handyutils

import java.math.RoundingMode
import java.text.DecimalFormat

fun Double.toDecimalPoints(points: Int, roundingMode: RoundingMode = RoundingMode.UNNECESSARY): String {
    val decimalFormat = DecimalFormat("0." + StringBuilder().apply { repeat(points) { append("0") } })
    if (roundingMode != RoundingMode.UNNECESSARY) {
        decimalFormat.roundingMode = roundingMode
    }
    return decimalFormat.format(this)
}