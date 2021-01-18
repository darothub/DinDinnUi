package com.darothub.dindinnui.adapter

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import coil.load
import coil.transform.RoundedCornersTransformation
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.darothub.dindinnui.R
import com.darothub.dindinnui.databinding.BottomSheetRecycleItemBinding
import com.darothub.dindinnui.databinding.FilterItemLayoutBinding
import com.darothub.dindinnui.model.FilterData
import com.darothub.dindinnui.model.ProductObject


@ModelView(autoLayout = ModelView.Size.WRAP_WIDTH_WRAP_HEIGHT, defaultLayout = R.layout.filter_item_layout)
class FilterView @JvmOverloads constructor(context: Context, attr:AttributeSet?=null, defStyleAttr:Int=0)
    : CardView(context, attr, defStyleAttr) {

    var binding :FilterItemLayoutBinding = FilterItemLayoutBinding.inflate(LayoutInflater.from(context),
        this, true)
    @ModelProp
    fun setData(filter: FilterData){
        binding.filterItemTextTv.text = filter.name
    }

}