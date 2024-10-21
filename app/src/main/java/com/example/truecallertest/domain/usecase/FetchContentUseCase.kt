package com.example.truecallertest.domain.usecase

import com.example.truecallertest.domain.model.Resource
import com.example.truecallertest.domain.repository.ContentRepository

class FetchContentUseCase(private val repository: ContentRepository) {
    suspend operator fun invoke(): Resource<String> {
        return repository.getContent()
    }
}