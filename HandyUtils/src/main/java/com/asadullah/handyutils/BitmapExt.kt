package com.asadullah.handyutils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.util.Base64
import java.io.ByteArrayOutputStream
import java.io.File
import java.util.Date

fun Bitmap.save(context: Context, fileName: String = Date().time.toString(), compressFormat: CompressFormat = CompressFormat.PNG, quality: Int = 100): Boolean {

    val parentDir = File(context.filesDir, "SavedBitmaps")
    parentDir.mkdirs()

    val savedBitmapFile = File(parentDir, fileName)

    return savedBitmapFile.outputStream().use {
        this.compress(
            compressFormat,
            quality,
            it
        )
    }
}

fun Bitmap.save(fileToSaveBitmapTo: File, compressFormat: CompressFormat = CompressFormat.PNG, quality: Int = 100): Boolean {
    return fileToSaveBitmapTo.outputStream().use {
        this.compress(
            compressFormat,
            quality,
            it
        )
    }
}

fun Bitmap.bitmapCompression(bitmap: Bitmap, compression: Int): Bitmap {
    if (compression >= 100) {
        return bitmap
    }

    val compressionFactor = if (compression < 10) {
        0.1F
    } else {
        compression / 100.0F
    }
    val newWidth = bitmap.width.toFloat() * compressionFactor
    val newHeight = bitmap.height.toFloat() * compressionFactor
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

fun Bitmap.toBase64(): String? {
    val byteArrayOutputStream = ByteArrayOutputStream()
    compress(CompressFormat.PNG, 100, byteArrayOutputStream)
    val b = byteArrayOutputStream.toByteArray()
    return Base64.encodeToString(b, Base64.NO_WRAP)
}