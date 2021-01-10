package com.darothub.dindinnui.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.darothub.dindinnui.R
import com.darothub.dindinnui.ViewPagerAdapter
import com.darothub.dindinnui.adapter.CarouselViewPagerAdapter
import com.darothub.dindinnui.data.DataList
import com.darothub.dindinnui.databinding.FragmentEntryBinding
import com.darothub.dindinnui.extensions.goto
import com.darothub.dindinnui.extensions.hide
import com.darothub.dindinnui.extensions.show
import com.darothub.dindinnui.model.ProductObject
import com.darothub.dindinnui.state.ProductState
import com.darothub.dindinnui.viewmodel.DrinkViewModel
import com.darothub.dindinnui.viewmodel.PizzaViewModel
import com.darothub.dindinnui.viewmodel.SushiViewModel
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayoutMediator

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val PRODUCT = "product"


/**
 * A simple [Fragment] subclass.
 * Use the [EntryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EntryFragment : BaseMvRxFragment() {
    lateinit var runnable: Runnable
    private val handler by lazy {
        Handler(Looper.getMainLooper())
    }


    lateinit var binding: FragmentEntryBinding

    private val pizzaViewModel: PizzaViewModel by activityViewModel()
    private val sushiViewModel: SushiViewModel by activityViewModel()
    private val drinkViewModel: DrinkViewModel by activityViewModel()
    override fun invalidate() {
        val fragList by lazy {
            arrayListOf<Fragment>()
        }

        addDataToList(pizzaViewModel, fragList)
        addDataToList(sushiViewModel, fragList)
        addDataToList(drinkViewModel, fragList)

        val bottomSheetViewPagerAdapter by lazy {
            val size = fragList.size
            ViewPagerAdapter(requireActivity(), size) {
                fragList[it]
            }
        }
        binding.bottomSheetVp2.adapter = bottomSheetViewPagerAdapter
        TabLayoutMediator(binding.productTablayout, binding.bottomSheetVp2) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.pizza_title)
                1 -> tab.text = getString(R.string.sushi)
                2 -> tab.text = getString(R.string.drinks)
            }
        }.apply {
            attach()
        }

    }

    private fun addDataToList(viewModel: BaseMvRxViewModel<ProductState>,fragList: ArrayList<Fragment>) {
        withState(viewModel) { state ->
            fragList.add(
                BottomFragment.newInstance(
                    state.products() as ArrayList<ProductObject>?
                )
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        changeStatusBarColor(R.color.white)
        // Inflate the layout for this fragment
        binding = FragmentEntryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CarouselViewPagerAdapter(DataList.dataList) {

        }

        binding.appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (verticalOffset < -35) {
                binding.mainEntryFab.show()
                binding.mainEntryCv.show()
            } else {
                binding.mainEntryFab.hide()
                binding.mainEntryCv.hide()
            }
        })
        binding.topViewpager2.adapter = adapter
        binding.circleIndicator.setViewPager(binding.topViewpager2)
        startAutoSlider(3);

        binding.mainEntryFab.setOnClickListener {
            goto(R.id.transactionFragment)
        }
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