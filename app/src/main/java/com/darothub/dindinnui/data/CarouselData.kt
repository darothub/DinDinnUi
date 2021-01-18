package com.darothub.dindinnui.data

data class CarouselData(val image: String, val title: String)

object DataList {
    val dataList = arrayListOf<CarouselData>(
        CarouselData("https://www.destinationunknown.com.au/sunshinecoast/wp-content/uploads/sites/11/2019/12/cheap-eats-monday-1.jpg", "DinDinn\nDelivery"),
        CarouselData(
            "https://i.pinimg.com/originals/27/49/f3/2749f38a63814125580fcacb711832a3.jpg",
            "DinDinn\n" +
                "Delivery"
        ),
        CarouselData(
            "https://www.babsprojects.com/wp-content/uploads/2013/03/WFW-button2.png",
            "DinDinn\n" +
                "Delivery"
        )
    )
}
