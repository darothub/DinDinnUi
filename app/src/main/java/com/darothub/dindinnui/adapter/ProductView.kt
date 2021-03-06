package com.darothub.dindinnui.adapter

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.cardview.widget.CardView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.darothub.dindinnui.R
import com.darothub.dindinnui.databinding.BottomSheetRecycleItemBinding
import com.darothub.dindinnui.model.ProductObject

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT, defaultLayout = R.layout.bottom_sheet_recycle_item)
class ProductView @JvmOverloads constructor(context: Context, attr: AttributeSet? = null, defStyleAttr: Int = 0) :
    CardView(context, attr, defStyleAttr) {

    var binding: BottomSheetRecycleItemBinding = BottomSheetRecycleItemBinding.inflate(
        LayoutInflater.from(context),
        this, true
    )
    @ModelProp
    fun setData(dataObject: ProductObject) {
        binding.imageIv.load(dataObject.image) {
            crossfade(true)
            placeholder(R.drawable.ic_baseline_fastfood_24)
            transformations(RoundedCornersTransformation(20F, 20F))
        }
        binding.textHeaderTv.text = dataObject.title
        binding.textBodyTv.text = dataObject.description
        binding.textGramTv.text = dataObject.weight
        binding.button.text = dataObject.price
    }

    @CallbackProp
    fun setClickListener(listener: View.OnClickListener?) {
        setOnClickListener(listener)
    }
    @CallbackProp
    fun buttonClickListener(listener: View.OnClickListener?) {
        binding.button.setOnClickListener(listener)
    }
    @CallbackProp
    fun buttonTouchListener(listener: View.OnTouchListener?) {
        binding.button.setOnTouchListener(listener)
    }
}
