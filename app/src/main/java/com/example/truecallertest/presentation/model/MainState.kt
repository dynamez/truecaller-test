package com.example.truecallertest.presentation.model

data class MainState(
    val fetchStatus: Status = Status.Idle,
    val task1Status: Status = Status.Idle,
    val task2Status: Status = Status.Idle,
    val task3Status: Status = Status.Idle,
    val errorMessage: String? = null,
    val character15: Char? = null,
    val every15thCharacter: List<Char> = emptyList(),
    val wordCount: List<Pair<String, Int>> = emptyList(),
    val task2Page: Int = 0,
    val task3Page: Int = 0
)