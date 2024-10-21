package com.example.truecallertest.domain.usecase

class GetEvery15thCharacterUseCase {
    operator fun invoke(content: String): List<Char> {
        return content.chunked(15).mapNotNull { it.lastOrNull() }
    }
}