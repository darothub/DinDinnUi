package com.darothub.dindinnui.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.darothub.dindinnui.adapter.cartListView
import com.darothub.dindinnui.databinding.FragmentCartBinding
import com.darothub.dindinnui.extensions.getName
import com.darothub.dindinnui.model.ProductObject
import com.darothub.dindinnui.viewmodel.CartViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [CartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CartFragment : BaseMvRxFragment() {

    lateinit var binding: FragmentCartBinding
    private val title by lazy {
        getName()
    }


    private val cartViewModel: CartViewModel by activityViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun invalidate() {

        withState(cartViewModel){state->
            binding.cartFragRv.withModels {
                state.cartItems.forEach { ci->
                    cartListView {
                        id(ci.id)
                        data(ci)

                        //Listener for removing items in the cart
                        onDeleteListener { _, _, _, position ->
                            cartViewModel.remove(position)
                            calculateAndUpdate(state.cartItems)
                            requestModelBuild()
                        }
                    }
                }


            }
            if(state.cartItems.isNotEmpty()){
                calculateAndUpdate(state.cartItems)
            }

        }
    }

    private fun calculateAndUpdate(cartItems: List<ProductObject>) {
        val total = cartItems.fold(0) { i, productObject ->
            i + productObject.price.replace("usd", "").toInt()
        }
        binding.totalTv.text = "${total}usd"
    }

}