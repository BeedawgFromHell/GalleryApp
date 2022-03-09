package com.example.galleryapp.di

import com.example.galleryapp.data.UserFileReader
import com.example.galleryapp.data.UserRepository
import com.example.galleryapp.data.UserRepositoryImpl
import com.example.galleryapp.userInfoScreen.InfoViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { UserFileReader(androidContext()) }

    factory { UserRepositoryImpl(get()) as UserRepository }

    viewModel { InfoViewModel(get()) }
}
