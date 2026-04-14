package com.example.imdbclone.utils

open class NetworkResult<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : NetworkResult<T>(data = data)
    class Loading<T> : NetworkResult<T>()
    class Failed<T>(message: String?) : NetworkResult<T>(message = message)
}