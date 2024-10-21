package com.example.truecallertest.domain.usecase

class GetWordCountUseCase {
    operator fun invoke(content: String): List<Pair<String, Int>> {
        return content.split("\\s+".toRegex())
            .filter { it.isNotBlank() }
            .groupingBy { it.lowercase() }
            .eachCount()
            .toList()
            .sortedByDescending { (_, count) -> count }
    }
}