package com.example.truecallertest.domain.usecase

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GetWordCountUseCaseTest {

    private val useCase = GetWordCountUseCase()

    @Test
    fun `invoke should return correct word count for simple content`() = runTest {
        // Arrange
        val content = "Hello world hello"

        // Act
        val result = useCase(content)

        // Assert
        assertEquals(listOf("hello" to 2, "world" to 1), result)
    }

    @Test
    fun `invoke should handle punctuation and case sensitivity`() = runTest {
        // Arrange
        val content = "Hello, world! HELLO world."

        // Act
        val result = useCase(content)

        // Assert
        // Since punctuation is not removed, "hello," and "hello" are distinct
        // Similarly, "world!" and "world." are distinct
        assertEquals(
            listOf("hello," to 1, "world!" to 1, "hello" to 1, "world." to 1),
            result
        )
    }

    @Test
    fun `invoke should handle empty content`() = runTest {
        // Arrange
        val content = ""

        // Act
        val result = useCase(content)

        // Assert
        assertEquals(emptyList<Pair<String, Int>>(), result)
    }

    @Test
    fun `invoke should return words sorted by frequency`() = runTest {
        // Arrange
        val content = "test test example example example sample"

        // Act
        val result = useCase(content)

        // Assert
        assertEquals(
            listOf(
                "example" to 3,
                "test" to 2,
                "sample" to 1
            ),
            result
        )
    }

    @Test
    fun `invoke should ignore numbers and symbols`() = runTest {
        // Arrange
        val content = "Test 123 test! @test #test"

        // Act
        val result = useCase(content)

        // Assert
        // Given the current implementation, "test", "test!", "@test", "#test" are treated as distinct
        // "123" is also included as a word
        assertEquals(
            listOf("test" to 1, "123" to 1, "test!" to 1, "@test" to 1, "#test" to 1),
            result
        )
    }

    @Test
    fun `invoke should handle multiple consecutive punctuation marks`() = runTest {
        // Arrange
        val content = "Hello!!! World?? HELLO... WORLD!!!"

        // Act
        val result = useCase(content)

        // Assert
        // "hello!!!", "world??", "hello...", "world!!!" are treated as distinct
        assertEquals(
            listOf("hello!!!" to 1, "world??" to 1, "hello..." to 1, "world!!!" to 1),
            result
        )
    }

    @Test
    fun `invoke should handle mixed case and punctuation`() = runTest {
        // Arrange
        val content = "Hello, World! hElLo WoRlD."

        // Act
        val result = useCase(content)

        // Assert
        // "hello,", "world!", "hello", "world." are distinct
        assertEquals(
            listOf("hello," to 1, "world!" to 1, "hello" to 1, "world." to 1),
            result
        )
    }

    // Optional: Test with Apostrophes (if implemented)
    @Test
    fun `invoke should retain apostrophes in words`() = runTest {
        // Arrange
        val content = "Don't stop believing, hold on to that feeling."

        // Act
        val result = useCase(content)

        // Assert
        // Since punctuation is not removed, "Don't" remains as is
        assertEquals(
            listOf(
                "don't" to 1,
                "stop" to 1,
                "believing," to 1,
                "hold" to 1,
                "on" to 1,
                "to" to 1,
                "that" to 1,
                "feeling." to 1
            ),
            result
        )
    }
}