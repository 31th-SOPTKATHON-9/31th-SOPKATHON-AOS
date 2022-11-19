package com.junewon.soptkathon.util.extension

import timber.log.Timber

inline fun <reified T : Enum<T>> safeValueOf(upperName: String?): T? = try {
    upperName?.let {
        java.lang.Enum.valueOf(T::class.java, it.uppercase())
    }
} catch (e: IllegalArgumentException) {
    Timber.e(e.stackTraceToString())
    null
}
