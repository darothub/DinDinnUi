package com.darothub.dindinnui.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.darothub.dindinnui.adapter.cartListView
import com.darothub.dindinnui.data.CartData
import com.darothub.dindinnui.data.PizzaData
import com.darothub.dindinnui.databinding.FragmentCartBinding
import com.darothub.dindinnui.extensions.getName

/**
 * A simple [Fragment] subclass.
 * Use the [CartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CartFragment : Fragment() {

    lateinit var binding: FragmentCartBinding
    private val title by lazy {
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

        val cartItems = CartData.cartItems
        if(cartItems.isNotEmpty()){
            Log.i(title, "items $cartItems")
          binding.cartFragRv.withModels {
              cartItems.forEach {ci->
                cartListView {
                    id(ci.id)
                    data(ci)
                    onDeleteListener { model, parentView, clickedView, position ->
                        cartItems.removeAt(position)
                        val total = cartItems.fold(0){i, productObject->
                            i + productObject.price.replace("usd", "").toInt()
                        }
                        binding.totalTv.text = "${total}usd"
                        requestModelBuild()
                    }
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