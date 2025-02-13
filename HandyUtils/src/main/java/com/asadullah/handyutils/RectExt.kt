package com.asadullah.handyutils

import android.graphics.Rect
import android.graphics.RectF
import kotlin.math.max
import kotlin.math.min

val Rect.area: Int
    get() = this.width() * this.height()

fun Rect.increaseBy(
    allSides: Int
): Rect {
    return Rect(
        this.left - allSides,
        this.top - allSides,
        this.right + allSides,
        this.bottom + allSides,
    )
}

fun Rect.increaseBy(
    left: Int,
    top: Int,
    right: Int,
    bottom: Int
): Rect {
    return Rect(
        this.left - left,
        this.top - top,
        this.right + right,
        this.bottom + bottom,
    )
}

fun Rect.decreaseBy(
    allSides: Int
): Rect {
    return Rect(
        this.left + allSides,
        this.top + allSides,
        this.right - allSides,
        this.bottom - allSides,
    )
}

fun Rect.decreaseBy(
    left: Int,
    top: Int,
    right: Int,
    bottom: Int
): Rect {
    return Rect(
        this.left + left,
        this.top + top,
        this.right - right,
        this.bottom - bottom,
    )
}

fun List<Rect>.encapsulate(): Rect {

    var left = Int.MIN_VALUE
    var top = Int.MIN_VALUE
    var right = Int.MAX_VALUE
    var bottom = Int.MAX_VALUE

    forEach { rect ->

        left = if (left == Int.MIN_VALUE) rect.left else min(left, rect.left)

        top = if (top == Int.MIN_VALUE) rect.top else min(top, rect.top)

        right = if (right == Int.MAX_VALUE) rect.right else max(right, rect.right)

        bottom = if (bottom == Int.MAX_VALUE) rect.bottom else max(bottom, rect.bottom)
    }

    return Rect(left, top, right, bottom)
}

val RectF.area: Float
    get() = this.width() * this.height()

fun RectF.increaseBy(
    allSides: Float
): RectF {
    return RectF(
        this.left - allSides,
        this.top - allSides,
        this.right + allSides,
        this.bottom + allSides,
    )
}

fun RectF.increaseBy(
    left: Float,
    top: Float,
    right: Float,
    bottom: Float
): RectF {
    return RectF(
        this.left - left,
        this.top - top,
        this.right + right,
        this.bottom + bottom,
    )
}

fun RectF.decreaseBy(
    allSides: Float
): RectF {
    return RectF(
        this.left + allSides,
        this.top + allSides,
        this.right - allSides,
        this.bottom - allSides,
    )
}

fun RectF.decreaseBy(
    left: Float,
    top: Float,
    right: Float,
    bottom: Float
): RectF {
    return RectF(
        this.left + left,
        this.top + top,
        this.right - right,
        this.bottom - bottom,
    )
}

fun List<RectF>.encapsulate(): RectF {

    var left = Float.MIN_VALUE
    var top = Float.MIN_VALUE
    var right = Float.MAX_VALUE
    var bottom = Float.MAX_VALUE

    forEach { rect ->

        left = if (left == Float.MIN_VALUE) rect.left else min(left, rect.left)

        top = if (top == Float.MIN_VALUE) rect.top else min(top, rect.top)

        right = if (right == Float.MAX_VALUE) rect.right else max(right, rect.right)

        bottom = if (bottom == Float.MAX_VALUE) rect.bottom else max(bottom, rect.bottom)
    }

    return RectF(left, top, right, bottom)
}