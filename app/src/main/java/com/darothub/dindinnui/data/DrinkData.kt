package com.darothub.dindinnui.data

import com.darothub.dindinnui.model.FilterData
import com.darothub.dindinnui.model.ProductObject

object DrinkData {
    val listOfDrinks = arrayListOf(
        ProductObject(
            0,
            "https://cdn-a.william-reed.com/var/wrbm_gb_food_pharma/storage/images/publications/food-beverage-nutrition/beveragedaily.com/news/markets/zero-alcohol-drinks-the-european-picture/10873182-4-eng-GB/Zero-alcohol-drinks-The-European-picture.jpg",
            "Beverage",
            "Hello Hope you like what you see",
            "25cm 30gram",
            "45usd"
        ),
        ProductObject(
            1,
            "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/barman-equipment-such-as-measuring-cups-and-essence-royalty-free-image-1062066858-1557252311.jpg",
            "Fantastic",
            "Hello Hope you like what you see",
            "25cm 30gram",
            "45usd"
        ),
        ProductObject(
            2,
            "https://www.themerlin.co.uk/content/dam/pcdg/common/offers/drinks/pcp-ln19-drinksmenu-cocktails-img.jpg.asset/1599476614718.jpg",
            "Cocktails",
            "Hello Hope you like what you see",
            "25cm 30gram",
            "45usd"
        ),
        ProductObject(
            3,
            "https://i.dailymail.co.uk/1s/2019/09/20/14/18720314-0-image-a-24_1568985945964.jpg",
            "Soft drinks",
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
