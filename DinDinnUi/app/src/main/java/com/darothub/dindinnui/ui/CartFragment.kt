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
import com.darothub.dindinnui.data.CartData
import com.darothub.dindinnui.data.CartData.cartItems
import com.darothub.dindinnui.data.PizzaData
import com.darothub.dindinnui.databinding.FragmentCartBinding
import com.darothub.dindinnui.extensions.getName
import com.darothub.dindinnui.model.ProductObject
import com.darothub.dindinnui.viewmodel.CartViewModel
import com.darothub.dindinnui.viewmodel.DrinkViewModel

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun invalidate() {
        withState(cartViewModel){state->
            binding.cartFragRv.withModels {
                state.addProduct.forEach { ci->
                    cartListView {
                        id(ci.id)
                        data(ci)
                        onDeleteListener { _, _, _, position ->
                            cartViewModel.remove(position)
                            calculateAndUpdate(state.addProduct)
                            requestModelBuild()
                        }
                    }
                }


            }
            if(state.addProduct.isNotEmpty()){
                Log.i(title, "items ${state.addProduct}")

                calculateAndUpdate(state.addProduct)
            }

        }
//        val cartItems = CartData.cartItems
//        if(cartItems.isNotEmpty()){
//            Log.i(title, "items $cartItems")
//
//            calculateAndUpdate(cartItems)
//        }
    }

    private fun calculateAndUpdate(cartItems: List<ProductObject>) {
        val total = cartItems.fold(0) { i, productObject ->
            i + productObject.price.replace("usd", "").toInt()
        }
        binding.totalTv.text = "${total}usd"
    }

}