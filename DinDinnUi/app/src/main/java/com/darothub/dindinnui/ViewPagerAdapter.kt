package com.darothub.dindinnui

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fm: FragmentActivity, val size:Int, val setFragment:(Int)->Fragment) : FragmentStateAdapter(fm) {


    override fun getItemCount(): Int {
        return size
    }

    override fun createFragment(position: Int): Fragment {
        Log.i("Fragmet $position", "$position")
        return setFragment(position)
    }
}