package com.example.galleryapp.userInfoScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.galleryapp.databinding.DefaultItemBinding
import com.example.galleryapp.domain.CompanyModel

class WorkHistoryAdapter(private val companies: List<CompanyModel>) :
    RecyclerView.Adapter<DefaultViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DefaultViewHolder(
        DefaultItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: DefaultViewHolder, position: Int) =
        holder.bind(companies[position])

    override fun getItemCount() = companies.size
}

class DefaultViewHolder(private val itemBinding: DefaultItemBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(item: CompanyModel) {
        itemBinding.apply {
            nameTv.text = item.name
            positionTv.text = item.position
        }
    }
}
