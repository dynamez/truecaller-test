package com.example.truecallertest.domain.model

sealed class Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class ApiError(val message: String, val code: Int) : Resource<Nothing>()
    data class NetworkError(val message: String) : Resource<Nothing>()
    data class UnknownError(val message: String) : Resource<Nothing>()
}