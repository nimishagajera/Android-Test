package com.app.test.ui.user

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.test.R
import com.app.test.databinding.FragmentUserBinding
import com.app.test.inTransaction
import com.app.test.model.State
import com.app.test.model.User
import com.app.test.ui.base.BaseFragment
import com.app.test.ui.user.map.MapActivity
import com.app.test.ui.user.map.MapsFragment
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class UserFragment : BaseFragment<FragmentUserBinding>() {

    private val userAdapter =  UserAdapter(this::onItemClicked)

    private val userViewModel by viewModels<UserViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        mViewBinding = FragmentUserBinding.inflate(inflater, container, false)

        mViewBinding.rvUser.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = userAdapter
        }
        mViewBinding.textRetry.setOnClickListener { getUsers() }

        initUsers()

        return mViewBinding.root
    }

    private fun initUsers() {
        userViewModel.userLiveData.observe(
            viewLifecycleOwner,
            { state ->
                when (state) {
                    is State.Loading -> showLoading(true)
                    is State.Success -> {
                        if (state.data.isNotEmpty()) {
                            showLoading(false)
                            userAdapter.submitList(state.data.toMutableList())
                        }
                    }
                    is State.Error -> {
                        showError(state.message)
                        showLoading(false)
                    }
                }
            }
        )
        // If State isn't `Success` then reload tracks.
        if (userViewModel.userLiveData.value !is State.Success)
            getUsers()
    }

    private fun getUsers() {
        userViewModel.getUsers()
    }

    private fun onItemClicked(user: User) {

        val intent = Intent(context, MapActivity::class.java)
        intent.putExtra("latitude", user.address.geo.lat)
        intent.putExtra("longitude", user.address.geo.lng)
        startActivity(intent)
    }

    /**
     * Shows [ProgressBar] for waiting while API is performing
     */
    private fun showLoading(isLoading: Boolean) {
        when(isLoading) {
            true -> {
                mViewBinding.progressBar.visibility = View.VISIBLE
                mViewBinding.textRetry.visibility = View.GONE
            }
            false ->
                mViewBinding.progressBar.visibility = View.GONE
        }
    }

    private fun showError(error: String) {
        mViewBinding.textRetry.visibility = View.VISIBLE
        Snackbar.make(mViewBinding.root, error, Snackbar.LENGTH_LONG)
            .setAction(R.string.text_retry){
                getUsers()
            }
            .show()
    }
}