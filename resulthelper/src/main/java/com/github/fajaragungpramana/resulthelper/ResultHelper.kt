package com.github.fajaragungpramana.resulthelper

sealed class ResultHelper<T> {

    data class OnSuccess<T>(
        val data: T? = null,
        val code: Int? = null,
        val message: String? = null
    ) : ResultHelper<T>()

    data class OnFailure<T>(
        val data: T? = null,
        val code: Int? = null,
        val message: String? = null
    ) : ResultHelper<T>()

    data class OnError<T>(val throwable: Throwable) : ResultHelper<T>()

}