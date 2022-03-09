package com.example.galleryapp.userInfoScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.galleryapp.data.UserRepository

class InfoViewModel(private val repository: UserRepository): ViewModel() {

    fun getUserData() = repository.getUser()
}