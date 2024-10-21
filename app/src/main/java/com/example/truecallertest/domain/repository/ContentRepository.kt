package com.example.truecallertest.domain.repository

import com.example.truecallertest.domain.model.Resource

interface ContentRepository {
    suspend fun getContent(): Resource<String>
}
