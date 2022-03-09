package com.example.galleryapp.data

import android.content.Context
import com.example.galleryapp.domain.UserModel
import com.example.galleryapp.domain.UserResponse
import kotlinx.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

class UserFileReader(private val context: Context) {
    companion object{
        private const val USER_INFO_FILE_NAME = "developer_info.json"
    }

    fun getUserInfo(): UserModel? {
        val inputStream = context.assets.open(USER_INFO_FILE_NAME)
        val byteArray = ByteArray(inputStream.available())
        inputStream.read(byteArray)
        return Json.decodeFromString(UserResponse.serializer(),String(byteArray)).user
    }
}