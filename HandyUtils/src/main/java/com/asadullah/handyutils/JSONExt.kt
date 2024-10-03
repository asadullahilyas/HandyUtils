package com.asadullah.handyutils

import org.json.JSONArray
import org.json.JSONObject

fun JSONObject.toMap(): Map<String, *> = keys().asSequence().associateWith {
    when (val value = this[it])
    {
        is JSONArray ->
        {
            val map = (0 until value.length()).associate { Pair(it.toString(), value[it]) }
            JSONObject(map).toMap().values.toList()
        }
        is JSONObject -> value.toMap()
        JSONObject.NULL -> null
        else            -> value
    }
}

fun JSONObject?.isNullOrEmpty() = this == null || this.length() == 0

fun JSONObject?.isNotEmpty() = this.isNullOrEmpty().not()

fun JSONArray?.isNullOrEmpty() = this == null || this.length() == 0

fun JSONArray?.isNotEmpty() = this.isNullOrEmpty().not()