package com.darothub.dindinnui.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.darothub.dindinnui.R
import com.darothub.dindinnui.ViewPagerAdapter
import com.darothub.dindinnui.databinding.FragmentTransactionBinding
import com.darothub.dindinnui.extensions.onBackDispatcher
import com.darothub.dindinnui.extensions.pop
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TransactionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TransactionFragment : Fragment() {

    lateinit var binding: FragmentTransactionBinding
    private val fadeOut: Animation by lazy{
        AnimationUtils.loadAnimation(requireContext(), R.anim.fade_out)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTransactionBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //On back pressed
        onBackDispatcher{
            pop()
        }

        //Fragment list for viewpager
        val fragList by lazy {
            arrayListOf(
                CartFragment(),
                OrderFragment(),
                InformationFragment()
            )
        }

        val viewPagerAdapter by lazy {
            ViewPagerAdapter(requireActivity(), 3) {
                fragList[it]
            }
        }

        binding.transactionToolbar.reusableAppbarToolbar.title = getString(R.string.menu)

        binding.transactionVp2.adapter = viewPagerAdapter

        TabLayoutMediator(binding.transactionTablayout, binding.transactionVp2) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.cart)
                1 -> tab.text = getString(R.string.order)
                2 -> tab.text = getString(R.string.information)
            }
        }.apply {
            attach()
        }

        //On back arrow click listener
        binding.transactionToolbar.reusableAppbarToolbar.setNavigationOnClickListener {
            pop()
        }

        binding.transactionFab.setOnClickListener {
            binding.transactionFab.animation = fadeOut
            val snackbar = Snackbar
                .make(binding.root, "Order is currently not available", Snackbar.LENGTH_LONG)
            snackbar.show()
        }
    }


}