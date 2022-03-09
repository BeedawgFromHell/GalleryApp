package com.example.galleryapp.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val user: UserModel? = null
)

@Serializable
data class UserModel(
    @SerialName("first_name") var firstName: String? = null,
    var photo: String? = null,
    @SerialName("second_name")var secondName: String? = null,
    var education: Int? = null,
    var company: List<CompanyModel>? = null
)

