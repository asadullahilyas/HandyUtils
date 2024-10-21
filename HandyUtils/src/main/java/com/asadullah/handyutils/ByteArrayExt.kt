package com.asadullah.handyutils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import androidx.annotation.RequiresApi
import java.util.Base64

@RequiresApi(Build.VERSION_CODES.O)
fun ByteArray.encodeToBase64String(): String {
    return Base64.getEncoder().encodeToString(this)
}

fun ByteArray.toBitmap(): Bitmap {
    return BitmapFactory.decodeByteArray(this, 0, this.size)
}