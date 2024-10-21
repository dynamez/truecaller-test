package com.example.truecallertest.domain.usecase

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GetEvery15thCharacterUseCaseTest {

    private val useCase = GetEvery15thCharacterUseCase()

    @Test
    fun `invoke should return last character of each 15-character chunk when content is long enough`() = runTest {
        // Arrange
        val content = "123456789012345" + // First chunk (15 chars), last char '5'
                "abcdefghijklmno" + // Second chunk (15 chars), last char 'o'
                "pqrstuvwxyzABCD"   // Adjusted to 15 chars, last char 'D'
        // Act
        val result = useCase(content)
        // Assert
        assertEquals(listOf('5', 'o', 'D'), result)
    }

    @Test
    fun `invoke should return empty list when content is empty`() = runTest {
        // Arrange
        val content = ""

        // Act
        val result = useCase(content)

        // Assert
        assertEquals(emptyList<Char>(), result)
    }

    @Test
    fun `invoke should handle content shorter than 15 characters`() = runTest {
        // Arrange
        val content = "Short content" // Less than 15 characters

        // Act
        val result = useCase(content)

        // Assert
        // The chunked function will create one chunk, and lastOrNull() will return the last character
        assertEquals(listOf('t'), result)
    }

    @Test
    fun `invoke should handle content length not a multiple of 15`() = runTest {
        // Arrange
        val content = "1234567890123456789012345678901234567890" // 40 characters
        // Chunks: [0-14], [15-29], [30-39]
        // Last characters of chunks: positions 14, 29, 39

        // Act
        val result = useCase(content)

        // Assert
        assertEquals(listOf('5', '0', '0'), result)
    }

    @Test
    fun `invoke should handle special characters and whitespace`() = runTest {
        // Arrange
        val content = "abcdefghijklmno" + // 15 chars
                "pqrstuvwxyzABCD" + // 15 chars
                "FGHIJKLMNOPQRST"   // 15 chars
        // Act
        val result = useCase(content)

        // Assert
        assertEquals(listOf('o', 'D', 'T'), result)
    }
}