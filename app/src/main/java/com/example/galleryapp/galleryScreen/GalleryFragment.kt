package com.example.galleryapp.galleryScreen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.galleryapp.databinding.GalleryFragmentBinding

class GalleryFragment: Fragment() {
    private var binding: GalleryFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = GalleryFragmentBinding.inflate(layoutInflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBtn()
    }

    private fun setBtn() {
        val adapter = GalleryAdapter()
        binding?.imagesRv?.apply {
            layoutManager = GridLayoutManager(requireContext(),2)
            this.adapter = adapter
        }

        val getImages = registerForActivityResult(ActivityResultContracts.GetMultipleContents()) {
            adapter.images = it
        }

        binding?.floatingBtn?.setOnClickListener {
            getImages.launch("image/*")
        }
    }

}