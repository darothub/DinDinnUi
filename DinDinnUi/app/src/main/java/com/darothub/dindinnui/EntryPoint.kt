package com.darothub.dindinnui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.darothub.dindinnui.adapter.CarouselViewPagerAdapter
import com.darothub.dindinnui.data.DataList
import com.darothub.dindinnui.databinding.ActivityEntryPointBinding
import com.darothub.dindinnui.ui.MainFragment

import com.google.android.material.tabs.TabLayoutMediator

class EntryPoint : AppCompatActivity() {
    lateinit var binding: ActivityEntryPointBinding
    lateinit var runnable: Runnable
    val handler by lazy {
        Handler(Looper.getMainLooper())
    }
    private val fragList by lazy {
        arrayListOf<Fragment>(
            MainFragment.newInstance("Hello", "Fragment $0"),
            MainFragment.newInstance("Hello", "Fragment $1"),
            MainFragment.newInstance("Hello", "Fragment $2")
        )
    }

    private val bottomSheetViewPagerAdapter by lazy {
        ViewPagerAdapter(this, 3) {
            fragList[it]
        }
    }

    private val viewPagerScrollListener by lazy {
        object :ViewPager2.OnPageChangeCallback(){

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)


                Log.i("ViewPagerScroll", "$position")
            }

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEntryPointBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val adapter = CarouselViewPagerAdapter(DataList.dataList) {

        }
        binding.topViewpager2.adapter = adapter
        binding.circleIndicator.setViewPager(binding.topViewpager2)

        binding.bs.bottomSheetVp2.adapter = bottomSheetViewPagerAdapter
        TabLayoutMediator(binding.bs.bottomSheetTabLayout, binding.bs.bottomSheetVp2,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position) {
                    0 -> tab.text = "Hello $position"
                    1 -> tab.text = "Hello $position"
                    2 -> tab.text = "Hello $position"
                }
            }).apply {
            attach()
        }

        binding.bs.bottomSheetVp2.registerOnPageChangeCallback(viewPagerScrollListener)

        startAutoSlider(3);

    }
    private fun startAutoSlider(count: Int) {
        runnable = Runnable {
            var pos: Int = binding.topViewpager2.currentItem
            pos += 1
            if (pos >= count) pos = 0
            binding.topViewpager2.currentItem = pos
            handler.postDelayed(runnable, 3000)

        }

        handler.postDelayed(runnable, 3000)
    }

    override fun onDestroy() {
        super.onDestroy()

        binding.bs.bottomSheetVp2.unregisterOnPageChangeCallback(viewPagerScrollListener)
    }
}