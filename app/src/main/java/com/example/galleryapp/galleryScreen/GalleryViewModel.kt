package com.example.galleryapp.galleryScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.galleryapp.data.UserRepository

class GalleryViewModel(): ViewModel() {



    class Factory(): ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            require(modelClass == GalleryViewModel::class.java)
            @Suppress("UNCHECKED_CAST") return GalleryViewModel() as T
        }
    }
}