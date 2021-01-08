package com.darothub.dindinnui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.darothub.dindinnui.adapter.CarouselViewPagerAdapter
import com.darothub.dindinnui.data.CarouselData
import com.darothub.dindinnui.data.DataList
import com.darothub.dindinnui.databinding.ActivityEntryBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.tabs.TabLayoutMediator


class EntryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEntryBinding
    lateinit var runnable: Runnable
    val handler by lazy {
        Handler(Looper.getMainLooper())
    }
    lateinit var behavior: BottomSheetBehavior<ConstraintLayout>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEntryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        binding.cordinatorLayout.viewTreeObserver.addOnGlobalLayoutListener {
//
//            binding.cordinatorLayout.viewTreeObserver.removeOnGlobalLayoutListener{}
//
//            val twentyPercent: Int = (binding.cordinatorLayout.height / 1).toInt()
//            val appbarParams: ViewGroup.LayoutParams = binding.appbar.layoutParams
//            appbarParams.height = twentyPercent
//            binding.appbar.layoutParams = appbarParams
//
//        }



        val adapter = CarouselViewPagerAdapter(DataList.dataList){

        }
        binding.topViewpager2.adapter = adapter
        binding.circleIndicator.setViewPager(binding.topViewpager2)

//        val bottomSheetViewPagerAdapter = ViewPagerAdapter(this)
//        binding.bs.bottomSheetVp2.adapter = bottomSheetViewPagerAdapter
//        TabLayoutMediator(binding.bs.bottomSheetTabLayout, binding.bs.bottomSheetVp2,
//            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
//                when (position) {
//                    0 -> tab.text = "Hello $position"
//                    1 -> tab.text = "Hello $position"
//                }
//            }).apply {
//            attach()
//        }

//        startAutoSlider(3);




//        behavior = BottomSheetBehavior.from(binding.bs.root)
//        val background = binding.bs.root.background
//
//        behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback(){
//            override fun onSlide(bottomSheet: View, slideOffset: Float) {
//            }
//
//            override fun onStateChanged(bottomSheet: View, newState: Int) {
//              when(newState){
//                    BottomSheetBehavior.STATE_EXPANDED -> {
//                        binding.bs.root.background.colorFilter = PorterDuffColorFilter(
//                            ContextCompat.getColor(this@EntryActivity, R.color.white),
//                            PorterDuff.Mode.SRC_IN
//                        )
//
//                    }
//                    BottomSheetBehavior.STATE_COLLAPSED -> {
//                        binding.bs.root.background = background
//
//                    }
//                    BottomSheetBehavior.STATE_DRAGGING -> {
//
//                    }
//                    else -> null
//                }
//            }
//
//        })
//

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

}