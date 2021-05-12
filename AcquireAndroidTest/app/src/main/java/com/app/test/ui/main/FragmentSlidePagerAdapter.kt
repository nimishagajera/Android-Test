package com.app.test.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.app.test.ui.photo.PhotosFragment
import com.app.test.ui.user.UserFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi

class FragmentSlidePagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 2
    }

    @ExperimentalCoroutinesApi
    override fun createFragment(position: Int): Fragment {
        var fragment = Fragment()
        when (position) {
            0 -> fragment = PhotosFragment()
            1 -> fragment = UserFragment()
        }
        return fragment
    }
}