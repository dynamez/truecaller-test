package com.example.truecallertest.data

import com.example.truecallertest.data.remote.retrofit.ApiService
import com.example.truecallertest.domain.model.Resource
import com.skydoves.sandwich.ApiResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import retrofit2.Response

class ContentRepositoryImplTest {

    private val apiService: ApiService = mockk()
    private val repository = ContentRepositoryImpl(apiService)

    @Test
    fun `getContent should return Resource Success`() = runTest {
        // Arrange
        val content = "Sample content"
        coEvery { apiService.fetchContent() } returns ApiResponse.Success(content)

        // Act
        val result = repository.getContent()

        // Assert
        assertTrue(result is Resource.Success)
    }

    @Test
    fun `getContent should return Resource ApiError`() = runTest {
        // Arrange
        val errorBody = ResponseBody.create("text/plain".toMediaTypeOrNull(), "Not Found")
        val response = Response.error<String>(404, errorBody)
        coEvery { apiService.fetchContent() } returns ApiResponse.Failure.Error(response)

        // Act
        val result = repository.getContent()

        // Assert
        assertTrue(result is Resource.ApiError)
    }

    @Test
    fun `getContent should return Resource NetworkError`() = runTest {
        // Arrange
        val exception = java.net.UnknownHostException()
        coEvery { apiService.fetchContent() } returns ApiResponse.Failure.Exception(exception)

        // Act
        val result = repository.getContent()

        // Assert
        assertTrue(result is Resource.NetworkError)
    }
}