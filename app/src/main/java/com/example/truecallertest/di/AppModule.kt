package com.example.truecallertest.di

import com.example.truecallertest.domain.repository.ContentRepository
import com.example.truecallertest.data.ContentRepositoryImpl
import com.example.truecallertest.data.remote.retrofit.ApiService
import com.example.truecallertest.domain.usecase.FetchContentUseCase
import com.example.truecallertest.domain.usecase.Get15thCharacterUseCase
import com.example.truecallertest.domain.usecase.GetEvery15thCharacterUseCase
import com.example.truecallertest.domain.usecase.GetWordCountUseCase
import com.example.truecallertest.presentation.MainViewModel
import com.skydoves.sandwich.retrofit.adapters.ApiResponseCallAdapterFactory
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

val appModule = module {

    single {
        Retrofit.Builder()
            .baseUrl("https://www.truecaller.com/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .build()
    }

    single<ApiService> { get<Retrofit>().create(ApiService::class.java) }

    single<ContentRepository> { ContentRepositoryImpl(get()) }

    factory { FetchContentUseCase(get()) }
    factory { Get15thCharacterUseCase() }
    factory { GetEvery15thCharacterUseCase() }
    factory { GetWordCountUseCase() }

    viewModel { MainViewModel(get(), get(), get(), get()) }
}