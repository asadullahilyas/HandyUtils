package com.asadullah.handyutils

import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast

/**
 * SDKHelper has been deprecated. Please use `AndroidVersion` class instead.
 */
@Deprecated(message = "Class `SDKHelper` has been deprecated. Please use `AndroidVersion` class instead.")
object SDKHelper {

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.M)
    fun hasAndroidM() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.M)
    fun hasAndroid23() = hasAndroidM()

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.N)
    fun hasAndroidN() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.N
    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.N)
    fun hasAndroid24() = hasAndroidN()

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.N_MR1)
    fun hasAndroidN1() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1
    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.N_MR1)
    fun hasAndroid25() = hasAndroidN1()

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.O)
    fun hasAndroidO() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.O)
    fun hasAndroid26() = hasAndroidO()

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.O_MR1)
    fun hasAndroidO1() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1
    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.O_MR1)
    fun hasAndroid27() = hasAndroidO1()

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.P)
    fun hasAndroidP() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.P
    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.P)
    fun hasAndroid28() = hasAndroidP()

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.Q)
    fun hasAndroidQ() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q
    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.Q)
    fun hasAndroid29() = hasAndroidQ()

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.R)
    fun hasAndroidR() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.R
    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.R)
    fun hasAndroid30() = hasAndroidR()

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
    fun hasAndroidS() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
    fun hasAndroid31() = hasAndroidS()

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S_V2)
    fun hasAndroidSv2() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S_V2
    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S_V2)
    fun hasAndroid32() = hasAndroidSv2()

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.TIRAMISU)
    fun hasAndroidT() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU
    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.TIRAMISU)
    fun hasAndroid33() = hasAndroidT()

    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    fun hasAndroidU() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE
    @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    fun hasAndroid34() = hasAndroidU()
}