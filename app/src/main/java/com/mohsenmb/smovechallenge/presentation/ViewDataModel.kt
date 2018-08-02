package com.mohsenmb.smovechallenge.presentation

sealed class ViewDataModel<T> {
    companion object {
        fun <T> loading(isLoading: Boolean): ViewDataModel<T> = Progress(isLoading)
        fun <T> success(data: T): ViewDataModel<T> = Success(data)
        fun <T> failed(error: Error): ViewDataModel<T> = Failure(error)
    }
}


data class Progress<T>(val loading: Boolean) : ViewDataModel<T>()
data class Success<T>(val data: T) : ViewDataModel<T>()
data class Failure<T>(val error: Error) : ViewDataModel<T>()

