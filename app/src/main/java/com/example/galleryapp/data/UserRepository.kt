package com.example.galleryapp.data

import com.example.galleryapp.domain.UserModel

interface UserRepository {
    fun getUser() : UserModel?
}