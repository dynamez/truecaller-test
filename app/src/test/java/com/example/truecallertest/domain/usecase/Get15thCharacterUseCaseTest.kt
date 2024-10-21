// src/test/java/com/example/truecallertest/domain/usecase/Get15thCharacterUseCaseTest.kt

package com.example.truecallertest.domain.usecase

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Get15thCharacterUseCaseTest {

    private val useCase = Get15thCharacterUseCase()

    @Test
    fun `invoke should return the 15th character when content is exactly 15 characters`() = runTest {
        // Arrange
        val content = "abcdefghijklmno" // 15 characters, last character 'o'

        // Act
        val result = useCase(content)

        // Assert
        assertEquals('o', result)
    }

    @Test
    fun `invoke should return the 15th character when content is longer than 15 characters`() = runTest {
        // Arrange
        val content = "12345678901234567890" // 20 characters, 15th character '5'

        // Act
        val result = useCase(content)

        // Assert
        assertEquals('5', result)
    }

    @Test
    fun `invoke should return null when content is shorter than 15 characters`() = runTest {
        // Arrange
        val content = "Short content" // 13 characters

        // Act
        val result = useCase(content)

        // Assert
        assertEquals(null, result)
    }

    @Test
    fun `invoke should return null when content is empty`() = runTest {
        // Arrange
        val content = ""

        // Act
        val result = useCase(content)

        // Assert
        assertEquals(null, result)
    }

    @Test
    fun `invoke should return the correct 15th character with special characters`() = runTest {
        // Arrange
        val content = "abcde!@#12345xyz" // 15 characters, last character 'z'

        // Act
        val result = useCase(content)

        // Assert
        assertEquals('y', result)
    }

    @Test
    fun `invoke should correctly identify the 15th character in mixed content`() = runTest {
        // Arrange
        val content = "Hello, World! 123" // 15 characters, last character '3'

        // Act
        val result = useCase(content)

        // Assert
        assertEquals('1', result)
    }

    @Test
    fun `invoke should handle newline and tab characters`() = runTest {
        // Arrange
        val content = "abcdefghijklmno\n\t" // 17 characters (includes newline and tab)

        // Act
        val result = useCase(content)

        // Assert
        // 15th character is 'o'
        assertEquals('o', result)
    }

    @Test
    fun `invoke should handle strings with exactly 15 spaces`() = runTest {
        // Arrange
        val content = "               " // 15 spaces

        // Act
        val result = useCase(content)

        // Assert
        assertEquals(' ', result)
    }

    @Test
    fun `invoke should return the 15th character when string contains repeated characters`() = runTest {
        // Arrange
        val content = "aaaaaaaaaaaaaaa" // 15 'a's

        // Act
        val result = useCase(content)

        // Assert
        assertEquals('a', result)
    }
}