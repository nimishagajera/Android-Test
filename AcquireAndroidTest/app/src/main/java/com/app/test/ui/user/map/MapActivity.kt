package com.app.test.ui.user.map

import android.os.Bundle
import com.app.test.R
import com.app.test.databinding.ActivityMapBinding
import com.app.test.inTransaction
import com.app.test.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MapActivity : BaseActivity<ActivityMapBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mViewBinding.root)

        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowHomeEnabled(true)

        val lat = intent.getStringExtra("latitude")
        val long = intent.getStringExtra("longitude")

        supportFragmentManager.inTransaction {
            val fragment = MapsFragment()
            val bundle = Bundle()
            bundle.putString("latitude", lat)
            bundle.putString("longitude", long)
            fragment.arguments = bundle
            add(R.id.fragment_container, fragment)
        }
    }

    override fun getViewBinding(): ActivityMapBinding = ActivityMapBinding.inflate(layoutInflater)
}