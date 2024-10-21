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

/**
 * If we execute the following code:
 *
 *     val weight1 = 20.5
 *     val weight2 = 20.0
 *     val jsonObject = JSONObject(mapOf(
 *         "weight1" to weight1,
 *         "weight2" to weight2
 *     ))
 *     val stringJson = jsonObject.toString()
 *     println(stringJson)
 *
 * we will get weight1 as `20.5` but we get weight2 as `20`. The `toString()` function
 * converts our double into an int. The `toSafeString` function maintains the types of
 * JSON items.
 */
fun JSONObject.toSafeString(): String {
    val sb = StringBuilder()
    sb.append("{")

    val keys = this.keys()
    var first = true

    while (keys.hasNext()) {
        val key = keys.next()
        val value = this.opt(key)  // Use opt to safely handle null values

        if (!first) {
            sb.append(",")
        }

        sb.append("\"").append(escapeJson(key)).append("\"").append(":")
        when (value) {
            is JSONObject -> sb.append(value.toSafeString()) // Recursively convert nested JSONObject
            is JSONArray -> sb.append(value.toSafeString()) // Convert JSONArray
            is String -> sb.append("\"").append(escapeJson(value)).append("\"")
            is Number, is Boolean -> sb.append(value.toString())
            else -> sb.append("null")
        }

        first = false
    }

    sb.append("}")
    return sb.toString()
}

/**
 * If we execute the following code:
 *
 *     val weight1 = 20.5
 *     val weight2 = 20.0
 *     val jsonObject = JSONObject(mapOf(
 *         "weight1" to weight1,
 *         "weight2" to weight2
 *     ))
 *     val stringJson = jsonObject.toString()
 *     println(stringJson)
 *
 * we will get weight1 as `20.5` but we get weight2 as `20`. The `toString()` function
 * converts our double into an int. The `toSafeString` function maintains the types of
 * JSON items.
 */
fun JSONArray.toSafeString(): String {
    val sb = StringBuilder()
    sb.append("[")

    for (i in 0 until this.length()) {
        if (i > 0) {
            sb.append(",")
        }

        val value = this.opt(i)  // Use opt to safely handle null values
        when (value) {
            is JSONObject -> sb.append(value.toSafeString()) // Recursively convert nested JSONObject
            is JSONArray -> sb.append(value.toSafeString()) // Recursively convert nested JSONArray
            is String -> sb.append("\"").append(escapeJson(value)).append("\"")
            is Number, is Boolean -> sb.append(value.toString())
            else -> sb.append("null")
        }
    }

    sb.append("]")
    return sb.toString()
}

private fun escapeJson(str: String): String {
    return str.replace("\\", "\\\\")
        .replace("\"", "\\\"")
        .replace("\b", "\\b")
        .replace("\u000c", "\\f")
        .replace("\n", "\\n")
        .replace("\r", "\\r")
        .replace("\t", "\\t")
}