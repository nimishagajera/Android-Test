package com.app.test.ui.user

import androidx.recyclerview.widget.RecyclerView
import com.app.test.databinding.ItemUserBinding
import com.app.test.generateAddress
import com.app.test.model.User

class UserViewHolder(private val itemUserBinding: ItemUserBinding) :
    RecyclerView.ViewHolder(itemUserBinding.root) {

    fun bind(user: User, onItemClicked: (User) -> Unit) {

        itemUserBinding.textName.text = user.name
        itemUserBinding.textEmail.text = user.email
        itemUserBinding.textCompany.text = user.company.name
        itemUserBinding.textPhone.text = user.phone

        val address = generateAddress(
            user.address.street,
            user.address.suite, user.address.city
        )
        itemUserBinding.textLocation.text = address

        itemUserBinding.root.setOnClickListener {
            onItemClicked(user)
        }
    }
}