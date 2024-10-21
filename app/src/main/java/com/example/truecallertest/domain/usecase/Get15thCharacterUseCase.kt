package com.example.truecallertest.domain.usecase

class Get15thCharacterUseCase {
    operator fun invoke(content: String): Char? {
        return if (content.length >= 15) content[14] else null
    }
}