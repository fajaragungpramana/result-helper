package com.github.fajaragungpramana.resulthelper

inline fun <T> ResultHelper<T>.onResultListener(
    onSuccess: (data: T?, code: Int?, message: String?) -> Unit,
    onFailure: (data: T?, code: Int?, message: String?) -> Unit,
    onError: (throwable: Throwable) -> Unit
) {
    when (this) {

        is ResultHelper.OnSuccess -> onSuccess(this.data, this.code, this.message)

        is ResultHelper.OnFailure -> onFailure(this.data, this.code, this.message)

        is ResultHelper.OnError -> onError(this.throwable)

    }
}

inline fun <T> ResultHelper<T>.onSuccess(onSuccess: (data: T?, code: Int?, message: String?) -> Unit) {
    if (this is ResultHelper.OnSuccess) onSuccess(this.data, this.code, this.message)
}

inline fun <T> ResultHelper<T>.onFailure(onFailure: (data: T?, code: Int?, message: String?) -> Unit) {
    if (this is ResultHelper.OnFailure) onFailure(this.data, this.code, this.message)
}

inline fun <T> ResultHelper<T>.onError(onError: (e: Throwable) -> Unit) {
    if (this is ResultHelper.OnError) onError(this.throwable)
}

inline fun <T> connection(run: () -> ResultHelper<T>): ResultHelper<T> =
    try {
        run()
    } catch (e: Throwable) {
        ResultHelper.OnError(e)
    }