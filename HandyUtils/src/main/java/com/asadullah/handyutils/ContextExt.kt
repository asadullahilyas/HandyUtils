package com.asadullah.handyutils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast

fun Context.copyToClipboard(text: CharSequence, shouldShowToast: Boolean = false) {
    val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("label", text)
    clipboard.setPrimaryClip(clip)
    if (shouldShowToast) {
        showToast("Copied")
    }
}

fun Context.showToast(text: CharSequence, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, length).show()
}

fun Context.getScreenWidth() = resources.displayMetrics.widthPixels
fun Context.getScreenHeight() = resources.displayMetrics.heightPixels