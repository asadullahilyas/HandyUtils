package com.asadullah.handyutils

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.Base64

@RequiresApi(Build.VERSION_CODES.O)
fun ByteArray.encodeToBase64String(): String {
    return Base64.getEncoder().encodeToString(this)
}