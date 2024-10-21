package com.example.truecallertest.presentation

import androidx.lifecycle.ViewModel
import com.example.truecallertest.domain.model.Resource
import com.example.truecallertest.domain.usecase.FetchContentUseCase
import com.example.truecallertest.domain.usecase.Get15thCharacterUseCase
import com.example.truecallertest.domain.usecase.GetEvery15thCharacterUseCase
import com.example.truecallertest.domain.usecase.GetWordCountUseCase
import com.example.truecallertest.presentation.model.MainSideEffect
import com.example.truecallertest.presentation.model.MainState
import com.example.truecallertest.presentation.model.Status
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

class MainViewModel(
    private val fetchContentUseCase: FetchContentUseCase,
    private val get15thCharacterUseCase: Get15thCharacterUseCase,
    private val getEvery15thCharacterUseCase: GetEvery15thCharacterUseCase,
    private val getWordCountUseCase: GetWordCountUseCase
) : ViewModel(), ContainerHost<MainState, MainSideEffect> {

    override val container = container<MainState, MainSideEffect>(MainState())

    private val task2ItemsPerPage = 15
    private val task3ItemsPerPage = 15

    private fun fetchContent() = intent {
        reduce { state.copy(fetchStatus = Status.Loading) }

        when (val resource = fetchContentUseCase()) {
            is Resource.Success -> {
                val content = resource.data
                reduce { state.copy(fetchStatus = Status.Success) }
                performTasks(content)
            }

            is Resource.ApiError -> {
                val errorMessage = "Error fetching content: ${resource.message}"
                reduce { state.copy(fetchStatus = Status.Error, errorMessage = errorMessage) }
                postSideEffect(MainSideEffect.ShowError(errorMessage))
            }

            is Resource.NetworkError -> {
                reduce { state.copy(fetchStatus = Status.Error, errorMessage = resource.message) }
                postSideEffect(MainSideEffect.ShowError(resource.message))
            }

            is Resource.UnknownError -> {
                val errorMessage = resource.message
                reduce { state.copy(fetchStatus = Status.Error, errorMessage = errorMessage) }
                postSideEffect(MainSideEffect.ShowError(errorMessage))
            }
        }
    }

    private fun performTasks(content: String) {
        performTask1(content)
        performTask2(content)
        performTask3(content)
    }

    private fun performTask1(content: String) = intent {
        reduce { state.copy(task1Status = Status.Loading) }
        val result = get15thCharacterUseCase(content)
        reduce {
            state.copy(
                task1Status = Status.Success,
                character15 = result
            )
        }
    }

    private fun performTask2(content: String) = intent {
        reduce { state.copy(task2Status = Status.Loading) }
        val result = getEvery15thCharacterUseCase(content)
        reduce {
            state.copy(
                task2Status = Status.Success,
                every15thCharacter = result,
                task2Page = 0
            )
        }
    }

    private fun performTask3(content: String) = intent {
        reduce { state.copy(task3Status = Status.Loading) }
        val result = getWordCountUseCase(content)
        reduce {
            state.copy(
                task3Status = Status.Success,
                wordCount = result,
                task3Page = 0
            )
        }
    }

    // Pagination functions for Task 2
    fun onTask2PreviousPageClicked() = intent {
        if (state.task2Page > 0) {
            reduce { state.copy(task2Page = state.task2Page - 1) }
        }
    }

    fun onTask2NextPageClicked() = intent {
        val totalPages = (state.every15thCharacter.size + task2ItemsPerPage - 1) / task2ItemsPerPage
        if (state.task2Page < totalPages - 1) {
            reduce { state.copy(task2Page = state.task2Page + 1) }
        }
    }

    // Pagination functions for Task 3
    fun onTask3PreviousPageClicked() = intent {
        if (state.task3Page > 0) {
            reduce { state.copy(task3Page = state.task3Page - 1) }
        }
    }

    fun onTask3NextPageClicked() = intent {
        val totalPages = (state.wordCount.size + task3ItemsPerPage - 1) / task3ItemsPerPage
        if (state.task3Page < totalPages - 1) {
            reduce { state.copy(task3Page = state.task3Page + 1) }
        }
    }

    fun onFetchContentClicked() {
        fetchContent()
    }

}
