package com.example.galleryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.galleryapp.databinding.MainActivityBinding
import com.example.galleryapp.userInfoScreen.InfoFragment

class MainActivity : AppCompatActivity() {

    private var binding: MainActivityBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }
}