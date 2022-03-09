package com.example.galleryapp.data

class UserRepositoryImpl (private val dao: UserFileReader): UserRepository {
    override fun getUser() = dao.getUserInfo()
}