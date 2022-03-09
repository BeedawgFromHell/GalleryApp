package com.example.galleryapp.userInfoScreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.galleryapp.R
import com.example.galleryapp.databinding.InfoFragmentBinding
import com.example.galleryapp.domain.UserModel
import com.example.galleryapp.tools.Education
import org.koin.android.ext.android.inject

class InfoFragment: Fragment() {
    private var binding: InfoFragmentBinding? = null
    private val viewModel by inject<InfoViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = InfoFragmentBinding.inflate(layoutInflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    @SuppressLint("SetTextI18n")
    private fun initViews() {
        viewModel.getUserData()?.setData()
        setBtn()
    }

    @SuppressLint("SetTextI18n")
    private fun UserModel.setData() {
        Glide.with(requireContext())
            .load(photo)
            .override(400, 1600)
            .into(binding!!.photoIv)

        binding?.nameTv?.text = "$secondName $firstName"
        binding?.educationTv?.text =
            Education.values().find { it.ordinal + 1 == education }?.value
        company?.let {
            binding?.workHistoryRv?.apply {
                addItemDecoration(
                    DividerItemDecoration(
                        requireContext(),
                        LinearLayoutManager.VERTICAL
                    )
                )
                adapter = WorkHistoryAdapter(it)
            }
        }
    }

    private fun setBtn() {
        binding?.galleryBtn?.setOnClickListener {
            findNavController(this).navigate(R.id.galleryFragment)
        }
    }
}