package com.darothub.dindinnui.adapter

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.darothub.dindinnui.R
import com.darothub.dindinnui.data.CarouselData
import com.darothub.dindinnui.databinding.CarouselItemLayoutBinding

class CarouselViewPagerAdapter (var list: List<CarouselData>, var listener:(CarouselData)->Unit):
    RecyclerView.Adapter<CarouselViewPagerAdapter.CarouselViewHolder>() {

    lateinit var binding: CarouselItemLayoutBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        binding = CarouselItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarouselViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item, listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(list: List<CarouselData?>?){
        this.list = list as List<CarouselData>
        notifyDataSetChanged()
    }
    fun getMessageAt(position: Int):CarouselData{
        return list[position]
    }



    class CarouselViewHolder(val binding: CarouselItemLayoutBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(data: CarouselData, listener: (CarouselData) -> Unit){
            binding.carouselItemIv.load(data.image){
                placeholder(R.drawable.ic_baseline_fastfood_24)
            }
            binding.carouselItemTv.text = data.title

            binding.root.setOnClickListener {
                listener(data)
            }
        }
    }
}


