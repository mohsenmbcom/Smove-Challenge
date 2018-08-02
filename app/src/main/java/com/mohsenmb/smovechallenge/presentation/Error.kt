package com.mohsenmb.smovechallenge.presentation

sealed class Error {
    companion object {
        fun unexpected() = UnexpectedError()
    }
}

class UnexpectedError : Error()