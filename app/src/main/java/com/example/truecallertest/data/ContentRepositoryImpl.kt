package com.example.truecallertest.data

import com.example.truecallertest.data.remote.retrofit.ApiService
import com.example.truecallertest.domain.model.Resource
import com.example.truecallertest.domain.repository.ContentRepository
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message
import com.skydoves.sandwich.retrofit.errorBody
import com.skydoves.sandwich.retrofit.statusCode
import java.io.IOException

class ContentRepositoryImpl(
    private val apiService: ApiService
) : ContentRepository {

    override suspend fun getContent(): Resource<String> {
        return when (val response = apiService.fetchContent()) {
            is ApiResponse.Success -> {
                Resource.Success(response.data)
            }

            is ApiResponse.Failure.Error -> {
                Resource.ApiError(
                    message = response.errorBody?.string() ?: response.message(),
                    code = response.statusCode.code
                )
            }

            is ApiResponse.Failure.Exception -> {
                if (response.throwable is IOException) {
                    Resource.NetworkError("No internet connection")
                } else {
                    Resource.UnknownError("An unexpected error occurred: ${response.throwable.message}")
                }
            }
        }
    }
}