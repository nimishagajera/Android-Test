package com.app.test.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.app.test.R
import com.app.test.databinding.ActivityMainBinding
import com.app.test.ui.base.BaseActivity
import com.app.test.ui.location.LocationActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mViewBinding.root)

        val sectionsPagerAdapter = FragmentSlidePagerAdapter(this)
        val viewPager: ViewPager2 = mViewBinding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = mViewBinding.tabs
        tabs.setupWithViewPager(viewPager)


        mViewBinding.fabLocation.setOnClickListener {
            startActivity(Intent(this@MainActivity, LocationActivity::class.java))
        }
    }

    private fun TabLayout.setupWithViewPager(viewPager: ViewPager2) {

        val TAB_TITLES = arrayOf(
            getString(R.string.tab_photos),
            getString(R.string.tab_users)
        )
        TabLayoutMediator(this, viewPager) { tab, position ->
            tab.text = TAB_TITLES[position]
        }.attach()
    }
    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
}