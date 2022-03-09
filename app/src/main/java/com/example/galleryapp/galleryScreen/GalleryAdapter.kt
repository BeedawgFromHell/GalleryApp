package com.example.galleryapp.galleryScreen

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.galleryapp.databinding.GalleryItemBinding

class GalleryAdapter : RecyclerView.Adapter<GalleryAdapter.ImageViewHolder>() {
    var images = listOf<Uri>()
        set(value){
            val callback = GalleryDiffCalback(field,value)
            val result = DiffUtil.calculateDiff(callback)
            result.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ImageViewHolder(
        GalleryItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) =
        holder.bind(images[position])

    override fun getItemCount() = images.size

    inner class ImageViewHolder(private val itemBinding: GalleryItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Uri) {
            Glide.with(itemBinding.root)
                .load(item)
                .override(800,1400)
                .into(itemBinding.imageIv)
        }
    }

    inner class GalleryDiffCalback(private val oldList: List<Uri>, private val newList: List<Uri>) :
        DiffUtil.Callback() {

        override fun getOldListSize() = oldList.size

        override fun getNewListSize() = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition] == newList[newItemPosition]

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition] == newList[newItemPosition]
    }
}
