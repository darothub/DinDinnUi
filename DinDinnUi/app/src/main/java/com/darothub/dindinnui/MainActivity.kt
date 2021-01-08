package com.darothub.dindinnui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.darothub.dindinnui.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var adapter : ViewPagerAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        adapter = ViewPagerAdapter(this)
//
//
//
//
//       binding.vp2.adapter = adapter
//        val tabLayoutMediator =
//                binding.vp2?.let {
//                    TabLayoutMediator(binding.profileManagementTabLayout, it,
//                            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
//                                when (position) {
//                                    0 -> tab.text = "Hello $position"
//                                    1 -> tab.text = "Hello $position"
//                                    2 -> tab.text = "Hello $position"
//                                    3 -> tab.text = "Hello $position"
//                                    4 -> tab.text = "Hello $position"
//                                    5 -> tab.text = "Hello $position"
//                                    6 -> tab.text = "Hello $position"
//                                    7 -> tab.text = "Hello $position"
//                                    8 -> tab.text = "Hello $position"
//                                    9 -> tab.text = "Hello $position"
//                                    10 -> tab.text = "Hello $position"
//                                    11 -> tab.text = "Hello $position"
//                                    12 -> tab.text = "Hello $position"
//                                }
//                            }).apply {
//                        attach()
//                    }
//                }

    }
}