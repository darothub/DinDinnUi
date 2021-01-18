package com.darothub.dindinnui.adapter

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.darothub.dindinnui.R
import com.darothub.dindinnui.databinding.FilterItemLayoutBinding
import com.darothub.dindinnui.model.FilterData

@ModelView(autoLayout = ModelView.Size.WRAP_WIDTH_WRAP_HEIGHT, defaultLayout = R.layout.filter_item_layout)
class FilterView @JvmOverloads constructor(context: Context, attr: AttributeSet? = null, defStyleAttr: Int = 0) :
    CardView(context, attr, defStyleAttr) {

    var binding: FilterItemLayoutBinding = FilterItemLayoutBinding.inflate(
        LayoutInflater.from(context),
        this, true
    )
    @ModelProp
    fun setData(filter: FilterData) {
        binding.filterItemTextTv.text = filter.name
    }
}
