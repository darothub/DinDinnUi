package com.darothub.dindinnui.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.darothub.dindinnui.R
import com.darothub.dindinnui.adapter.cartListView
import com.darothub.dindinnui.data.ProductData
import com.darothub.dindinnui.databinding.FragmentCartBinding
import com.darothub.dindinnui.databinding.FragmentEntryBinding
import com.darothub.dindinnui.extensions.getName

/**
 * A simple [Fragment] subclass.
 * Use the [CartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CartFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var binding: FragmentCartBinding
    val title by lazy {
        getName()
    }

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

        val cartItems = ProductData.cartItems
        if(cartItems.isNotEmpty()){
            Log.i(title, "items $cartItems")
          binding.cartFragRv.withModels {
              cartItems.forEach {ci->
                cartListView {
                    id(ci.id)
                    data(ci)
                }
              }
          }
            val total = cartItems.fold(0){i, productObject->
                i + productObject.price.replace("usd", "").toInt()
            }
            binding.totalTv.text = "${total}usd"
        }
    }

}