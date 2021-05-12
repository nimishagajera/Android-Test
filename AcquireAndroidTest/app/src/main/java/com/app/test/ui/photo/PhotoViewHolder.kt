package com.app.test.ui.photo

import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.app.test.R
import com.app.test.databinding.ItemPhotoBinding
import com.app.test.model.Photo

class PhotoViewHolder(private val photoBinding: ItemPhotoBinding):
    RecyclerView.ViewHolder(photoBinding.root) {

        fun bind(photoItem: Photo) {

            photoBinding.textTitle.text = photoItem.title
            photoBinding.imageAlbum.load(photoItem.thumbnailUrl) {
                placeholder(R.drawable.ic_launcher_background)
                error(R.drawable.ic_launcher_background)
            }
        }
}