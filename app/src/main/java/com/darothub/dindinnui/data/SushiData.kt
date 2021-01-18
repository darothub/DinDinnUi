package com.darothub.dindinnui.data

import com.darothub.dindinnui.model.FilterData
import com.darothub.dindinnui.model.ProductObject

object SushiData {
    val listOfSushi = arrayListOf<ProductObject>(
        ProductObject(
            0,
            "https://www.kikkoman.com/homecook/search/recipe/img/00005163.jpg",
            "The egoist",
            "Hello Hope you like what you see",
            "25cm 30gram",
            "45usd"
        ),
        ProductObject(
            1,
            "https://www.tripsavvy.com/thmb/CP_SGOYRfjCZLjVQjeAsvsEylSg=/5096x2866/smart/filters:no_upscale()/GettyImages-126553802-56a541cb3df78cf772875a68.jpg",
            "California",
            "Hello Hope you like what you see",
            "25cm 30gram",
            "45usd"
        ),
        ProductObject(
            2,
            "https://img.webmd.com/dtmcms/live/webmd/consumer_assets/site_images/article_thumbnails/slideshows/best_and_worst_sushi_slideshow/1800x1200_best_and_worst_sushi_slideshow.jpg",
            "Nigeria",
            "Hello Hope you like what you see",
            "25cm 30gram",
            "45usd"
        ),
        ProductObject(
            3,
            "https://www.nippon.com/en/ncommon/contents/japan-data/169591/169591.jpg",
            "Africaroni",
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
