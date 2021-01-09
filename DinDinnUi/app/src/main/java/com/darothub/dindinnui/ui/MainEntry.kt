package com.darothub.dindinnui.ui

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.darothub.dindinnui.ViewPagerAdapter
import com.darothub.dindinnui.adapter.CarouselViewPagerAdapter
import com.darothub.dindinnui.data.DataList
import com.darothub.dindinnui.databinding.ActivityMainEntryBinding
import com.darothub.dindinnui.extensions.hide
import com.darothub.dindinnui.extensions.show
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
import com.google.android.material.tabs.TabLayoutMediator


class MainEntry : AppCompatActivity() {
    lateinit var binding: ActivityMainEntryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        binding = ActivityMainEntryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }


}