// src/test/java/com/example/truecallertest/presentation/viewmodel/MainViewModelTest.kt

package com.example.truecallertest.presentation

import com.example.truecallertest.domain.model.Resource
import com.example.truecallertest.domain.usecase.*
import com.example.truecallertest.presentation.model.*
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.*
import org.orbitmvi.orbit.test.test

@ExperimentalCoroutinesApi
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MainViewModelTest {

    // Mocks
    private val fetchContentUseCase: FetchContentUseCase = mockk()
    private val get15thCharacterUseCase: Get15thCharacterUseCase = mockk()
    private val getEvery15thCharacterUseCase: GetEvery15thCharacterUseCase = mockk()
    private val getWordCountUseCase: GetWordCountUseCase = mockk()

    private lateinit var viewModel: MainViewModel

    private lateinit var testDispatcher: TestDispatcher
    private lateinit var testScope: TestScope

    @BeforeAll
    fun setUp() {
        testDispatcher = StandardTestDispatcher()
        testScope = TestScope(testDispatcher)
        Dispatchers.setMain(testDispatcher)
    }

    @BeforeEach
    fun beforeEach() {
        viewModel = MainViewModel(
            fetchContentUseCase,
            get15thCharacterUseCase,
            getEvery15thCharacterUseCase,
            getWordCountUseCase
        )
    }

    @AfterAll
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `fetchContent should update state correctly on success`() = runTest {
        // Arrange
        val content = "This is the fetched content."
        coEvery { fetchContentUseCase() } returns Resource.Success(content)
        every { get15thCharacterUseCase(content) } returns 'f'
        every { getEvery15thCharacterUseCase(content) } returns listOf('f', 'n')
        every { getWordCountUseCase(content) } returns listOf("this" to 1, "is" to 1)

        // Act
        val testContainer = viewModel.test(
            this
        ) {
            MainState()
            containerHost.fetchContent()

            //Assert
            expectState { copy(fetchStatus = Status.Loading) }
            expectState { copy(fetchStatus = Status.Success) }
            expectState { copy(task1Status = Status.Loading) }
            expectState { copy(task1Status = Status.Success, character15 = 'f') }
            expectState { copy(task2Status = Status.Loading) }
            expectState { copy(task2Status = Status.Success, every15thCharacter = listOf('f', 'n'), task2Page = 0) }
            expectState { copy(task3Status = Status.Loading) }
            expectState { copy(task3Status = Status.Success, wordCount = listOf("this" to 1, "is" to 1), task3Page = 0) }
        }

    }
}