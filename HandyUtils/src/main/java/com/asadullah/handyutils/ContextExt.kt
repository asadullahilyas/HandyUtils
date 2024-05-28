package com.asadullah.handyutils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.DisplayMetrics
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.withContext
import java.net.InetAddress
import java.net.UnknownHostException

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

fun Context.toDp(px: Int) = px / (resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)
fun Context.toPixel(dp: Int) = dp * (resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)

fun Context.isNetworkAvailable(): Boolean {
    val connectivityManager = getSystemService(ConnectivityManager::class.java)
    val networkCapabilities = connectivityManager.activeNetwork ?: return false
    val actNw = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
    return when {
        actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
        actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
        actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
        actNw.hasTransport(NetworkCapabilities.TRANSPORT_VPN) -> true
        else -> false
    }
}

suspend fun Context.isInternetAvailable(url: String = "www.stackoverflow.com"): Boolean {
    if (isNetworkAvailable().not()) return false

    val currentContext = currentCoroutineContext()

    val result = withContext(Dispatchers.IO) {
        try {
            val address = InetAddress.getByName(url)
            return@withContext !address.equals("")
        } catch (e: UnknownHostException) {
            e.printStackTrace()
            return@withContext false
        }
    }

    return withContext(currentContext) {
        result
    }
}