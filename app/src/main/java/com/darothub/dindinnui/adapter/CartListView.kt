package com.darothub.dindinnui.adapter

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import coil.load
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.darothub.dindinnui.R
import com.darothub.dindinnui.databinding.CartItemBinding
import com.darothub.dindinnui.model.ProductObject

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT, defaultLayout = R.layout.cart_item)
class CartListView @JvmOverloads constructor(context: Context, attr: AttributeSet? = null, defStyleAttr: Int = 0) :
    ConstraintLayout(context, attr, defStyleAttr) {

    var binding: CartItemBinding = CartItemBinding.inflate(
        LayoutInflater.from(context),
        this, true
    )
    @ModelProp
    fun setData(cartData: ProductObject) {
        binding.cardItemImage.load(cartData.image) {
            placeholder(R.drawable.ic_baseline_fastfood_24)
        }
        binding.cardItemTitle.text = cartData.title
        binding.cardItemPrice.text = cartData.price
    }

    @CallbackProp
    fun setOnDeleteListener(listener: OnClickListener?) {
        binding.cardItemDelete.setOnClickListener(listener)
    }
}
