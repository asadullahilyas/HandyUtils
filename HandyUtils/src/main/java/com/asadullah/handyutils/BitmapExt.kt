package com.asadullah.handyutils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.util.Base64
import java.io.ByteArrayOutputStream
import java.io.File
import java.util.Date

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
    return resize(newWidth.toInt(), newHeight.toInt())
}

fun Bitmap.resize(maxWidth: Int, maxHeight: Int): Bitmap {
    if (maxHeight <= 0 || maxWidth <= 0) {
        return this
    }

    val width = width
    val height = height
    val ratioBitmap = width.toFloat() / height.toFloat()
    val ratioMax = maxWidth.toFloat() / maxHeight.toFloat()
    var finalWidth = maxWidth
    var finalHeight = maxHeight
    if (ratioMax > ratioBitmap) {
        finalWidth = (maxHeight.toFloat() * ratioBitmap).toInt()
    } else {
        finalHeight = (maxWidth.toFloat() / ratioBitmap).toInt()
    }
    return Bitmap.createScaledBitmap(this, finalWidth, finalHeight, true)
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
