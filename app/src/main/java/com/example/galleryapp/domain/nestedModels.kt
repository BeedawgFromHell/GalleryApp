package com.example.galleryapp.domain

import kotlinx.serialization.Serializable

@Serializable
data class CompanyModel(
    var name: String,
    var position: String
)