package com.example.truecallertest.data.remote.retrofit

import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface ApiService {

    @GET("blog/life-at-truecaller/life-as-an-android-engineer")
    suspend fun fetchContent(): ApiResponse<String>
}
