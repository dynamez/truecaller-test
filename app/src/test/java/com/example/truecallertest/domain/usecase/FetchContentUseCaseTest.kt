package com.example.truecallertest.domain.usecase

import com.example.truecallertest.domain.model.Resource
import com.example.truecallertest.domain.repository.ContentRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FetchContentUseCaseTest {

    private val repository: ContentRepository = mockk()
    private val useCase = FetchContentUseCase(repository)

    @Test
    fun `invoke should return Resource Success`() = runTest {
        // Arrange
        val content = "Sample content"
        coEvery { repository.getContent() } returns Resource.Success(content)

        // Act
        val result = useCase()

        // Assert
        assertEquals(Resource.Success(content), result)
    }

    @Test
    fun `invoke should return Resource NetworkError`() = runTest {
        // Arrange
        val errorMessage = "No internet connection"
        coEvery { repository.getContent() } returns Resource.NetworkError(errorMessage)

        // Act
        val result = useCase()

        // Assert
        assertEquals(Resource.NetworkError(errorMessage), result)
    }
}