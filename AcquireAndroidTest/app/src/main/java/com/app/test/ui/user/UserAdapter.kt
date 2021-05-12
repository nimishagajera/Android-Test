package com.app.test.ui.user

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.app.test.databinding.ItemUserBinding
import com.app.test.model.User

class UserAdapter(private val onItemClicked: (User) -> Unit):
    ListAdapter<User, UserViewHolder>(DIFF_CALLBACK) {

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) =
        holder.bind(getItem(position), onItemClicked)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder (
        ItemUserBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
                oldItem == newItem
        }
    }
}