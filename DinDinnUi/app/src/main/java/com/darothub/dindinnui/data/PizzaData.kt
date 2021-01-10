package com.darothub.dindinnui.data

import com.darothub.dindinnui.model.FilterData
import com.darothub.dindinnui.model.ProductObject

object PizzaData {
    val listOfPizza = arrayListOf<ProductObject>(
        ProductObject(
            0,
            "https://media.sproutsocial.com/uploads/2017/02/10x-featured-social-media-image-size.png",
            "Deluxe",
            "Hello Hope you like what you see",
            "25cm 30gram",
            "45usd"
        ),
        ProductObject(
            1,
            "https://media.sproutsocial.com/uploads/2017/02/10x-featured-social-media-image-size.png",
            "Hawaiian",
            "Hello Hope you like what you see",
            "25cm 30gram",
            "45usd"
        ),
        ProductObject(
            2,
            "https://media.sproutsocial.com/uploads/2017/02/10x-featured-social-media-image-size.png",
            "Peperoni",
            "Hello Hope you like what you see",
            "25cm 30gram",
            "45usd"
        ),
        ProductObject(
            3,
            "https://media.sproutsocial.com/uploads/2017/02/10x-featured-social-media-image-size.png",
            "Standard",
            "Hello Hope you like what you see",
            "25cm 30gram",
            "45usd"
        )


    )
    val listOfFilter = arrayListOf<FilterData>(
        FilterData(0, "Food"),
        FilterData(1, "Drink")
    )


}