package com.app.test.ui.photo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.test.R
import com.app.test.databinding.FragmentPhotoBinding
import com.app.test.model.State
import com.app.test.ui.base.BaseFragment
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class PhotosFragment : BaseFragment<FragmentPhotoBinding>() {

    private lateinit var photoAdapter: PhotoAdapter

    private val photoViewModel by viewModels<PhotoViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:
    Bundle?): View? {

        mViewBinding = FragmentPhotoBinding.inflate(inflater, container, false)
        photoAdapter = PhotoAdapter()
        mViewBinding.rvPhoto.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = photoAdapter
        }

        initPhotos()

        mViewBinding.textRetry.setOnClickListener { getPhotos() }

        return mViewBinding.root
    }

    private fun initPhotos() {
        photoViewModel.photoLiveData.observe(
            viewLifecycleOwner,
            { state ->
                when (state) {
                    is State.Loading -> showLoading(true)
                    is State.Success -> {
                        if (state.data.isNotEmpty()) {
                            showLoading(false)
                            photoAdapter.submitList(state.data.toMutableList())
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
        if (photoViewModel.photoLiveData.value !is State.Success)
            getPhotos()
    }

    private fun getPhotos() {
        photoViewModel.getPhotos()
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
                getPhotos()
            }
            .show()
    }
}