package com.asadullah.handyutils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.graphics.Matrix
import android.util.Base64
import java.io.ByteArrayOutputStream
import java.io.File
import java.text.NumberFormat
import java.util.Date
import kotlin.math.max
import kotlin.math.roundToInt
import androidx.core.graphics.scale

fun Bitmap.save(context: Context, fileName: String = Date().time.toString(), compressFormat: CompressFormat = CompressFormat.JPEG, quality: Int = 100): File? {

    val parentDir = File(context.filesDir, "SavedBitmaps")
    parentDir.mkdirs()

    val savedBitmapFile = File(parentDir, fileName)

    return savedBitmapFile.outputStream().use {
        this.compress(
            compressFormat,
            quality,
            it
        ).executeForTrueNullForFalse {
            savedBitmapFile
        }
    }
}

fun Bitmap.save(fileToSaveBitmapTo: File, compressFormat: CompressFormat = CompressFormat.JPEG, quality: Int = 100): File? {
    return fileToSaveBitmapTo.outputStream().use {
        this.compress(
            compressFormat,
            quality,
            it
        ).executeForTrueNullForFalse {
            fileToSaveBitmapTo
        }
    }
}

/**
 * This function will compress the given bitmap by percentage.
 * If you pass quality as 100, it will not be compressed at all.
 * If you pass quality as 50, the function will reduce the width
 * and height of image by 50%.
 *
 * @param quality: Quality can range from 10 to 100. Other values
 * will be coerced to the given range.
 */
fun Bitmap.bitmapCompression(quality: Int): Bitmap {
    if (quality >= 100) {
        return this
    }

    val compressionFactor = if (quality < 10) {
        0.1F
    } else {
        quality / 100.0F
    }
    val newWidth = this.width.toFloat() * compressionFactor
    val newHeight = this.height.toFloat() * compressionFactor
    val maxSide = max(newWidth, newHeight)
    return resize(maxSide.toInt())
}

/**
 * This function will try to reduce the size of current Bitmap and
 * make its one side (width or height) at least equal to maxSide.
 * This function will keep aspect ratio intact. Following is the
 * edge case where aspect ratio will suffer:
 *
 * Original Bitmap size: width = 100, height = 1, maxSide = 50
 *
 * Result Bitmap size: width = 50, height = 1
 *
 * Note that in this case, aspect ratio has been changed.
 *
 * @param maxSide: Maximum side you want your Bitmap to have. If
 * 0 or a negative number is passed, Bitmap is returned as it is.
 * If maxSide is greater than both sides of current Bitmap, it is
 * returned as it is.
 */
fun Bitmap.resize(maxSide: Int): Bitmap {

    // If maxSide 0 or a negative number, then return Bitmap as it is.
    if (maxSide <= 0) {
        return this
    }

    // If maxSide is greater than both width and height, then return
    // Bitmap as it is, because we are not scaling up the Bitmap.
    if (maxSide >= width && maxSide >= height) {
        return this
    }

    val (newWidth, newHeight) = if (width > height) {
        val newHeight = maxSide / (width.toFloat() / height.toFloat())
        maxSide.toFloat() to newHeight
    } else if (height > width) {
        val newWidth = maxSide / (height.toFloat() / width.toFloat())
        newWidth to maxSide.toFloat()
    } else {
        maxSide.toFloat() to maxSide.toFloat()
    }

    return this.scale(max(newWidth.toInt(), 1), max(newHeight.toInt(), 1))
}

fun Bitmap.rotateClockwise(angle: Float): Bitmap {
    return Bitmap.createBitmap(
        this,
        0,
        0,
        this.width,
        this.height,
        Matrix().apply { postRotate(angle) },
        true
    )
}

fun Bitmap.rotateAnticlockwise(angle: Float): Bitmap {
    return Bitmap.createBitmap(
        this,
        0,
        0,
        this.width,
        this.height,
        Matrix().apply { postRotate(360 - angle) },
        true
    )
}

fun Bitmap.toByteArray(compressFormat: CompressFormat = CompressFormat.JPEG, quality: Int = 100): ByteArray {
    val byteArrayOutputStream = ByteArrayOutputStream()
    compress(compressFormat, quality, byteArrayOutputStream)
    return byteArrayOutputStream.toByteArray()
}

fun Bitmap.toBase64(compressFormat: CompressFormat = CompressFormat.JPEG, quality: Int = 100, flags: Int = Base64.NO_WRAP): String {
    return Base64.encodeToString(
        toByteArray(
            compressFormat, quality
        ),
        flags
    )
}
