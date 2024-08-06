package com.asadullah.handyutils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun CoroutineScope.launchOnMain(block: suspend CoroutineScope.() -> Unit): Job {
    return this.launch(
        context = Dispatchers.Main,
        block = block
    )
}

fun CoroutineScope.launchOnDefault(block: suspend CoroutineScope.() -> Unit): Job {
    return this.launch(
        context = Dispatchers.Default,
        block = block
    )
}

fun CoroutineScope.launchOnIO(block: suspend CoroutineScope.() -> Unit): Job {
    return this.launch(
        context = Dispatchers.IO,
        block = block
    )
}

fun <T> CoroutineScope.asyncOnMain(block: suspend CoroutineScope.() -> T): Deferred<T> {
    return this.async(
        context = Dispatchers.Main,
        block = block
    )
}

fun <T> CoroutineScope.asyncOnDefault(block: suspend CoroutineScope.() -> T): Deferred<T> {
    return this.async(
        context = Dispatchers.Default,
        block = block
    )
}

fun <T> CoroutineScope.asyncOnIO(block: suspend CoroutineScope.() -> T): Deferred<T> {
    return this.async(
        context = Dispatchers.IO,
        block = block
    )
}

suspend fun <T> withContextMain(
    block: suspend CoroutineScope.() -> T
): T {
    return withContext(Dispatchers.Main, block)
}

suspend fun <T> withContextDefault(
    block: suspend CoroutineScope.() -> T
): T {
    return withContext(Dispatchers.Default, block)
}

suspend fun <T> withContextIO(
    block: suspend CoroutineScope.() -> T
): T {
    return withContext(Dispatchers.IO, block)
}