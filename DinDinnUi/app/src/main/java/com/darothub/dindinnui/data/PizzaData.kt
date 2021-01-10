package com.darothub.dindinnui.data

import com.darothub.dindinnui.model.FilterData
import com.darothub.dindinnui.model.ProductObject

object PizzaData {
    val listOfPizza = arrayListOf<ProductObject>(
        ProductObject(
            0,
            "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/delish-homemade-pizza-horizontal-1542312378.png",
            "Deluxe",
            "Hello Hope you like what you see",
            "25cm 30gram",
            "45usd"
        ),
        ProductObject(
            1,
            "https://www.insidetherustickitchen.com/wp-content/uploads/2020/07/Quattro-formaggi-pizza-square-Inside-the-rustic-kitchen-500x500.jpg",
            "Hawaiian",
            "Hello Hope you like what you see",
            "25cm 30gram",
            "45usd"
        ),
        ProductObject(
            2,
            "https://www.thespruceeats.com/thmb/c57iCi93U2l6xHJ1Af4kz6OLo38=/3661x3661/smart/filters:no_upscale()/hawaiian-pizza-4691857-hero-01-1a8f6764c70e4113bbf31bd1a73aca2e.jpg",
            "Peperoni",
            "Hello Hope you like what you see",
            "25cm 30gram",
            "45usd"
        ),
        ProductObject(
            3,
            "https://i.ytimg.com/vi/beYik-V6jiE/maxresdefault.jpg",
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