package com.darothub.dindinnui.data

data class CarouselData(val image:String, val title:String)

object DataList{
    val dataList = arrayListOf<CarouselData>(
        CarouselData("https://www.gizbot.com/images/2020-09/realme-7_159921061900.jpg", "Image 1"),
        CarouselData("https://tech2tech.com.cy/wp-content/uploads/realme-7-1.jpg", "Image 2"),
        CarouselData("https://detspec.com/wp-content/uploads/2020/12/realme-7.jpg", "Image 3")

    )
}