package com.darothub.dindinnui.repository

import com.darothub.dindinnui.data.DrinkData
import com.darothub.dindinnui.data.PizzaData
import com.darothub.dindinnui.data.SushiData
import com.darothub.dindinnui.model.ProductObject
import io.reactivex.Observable
import io.reactivex.Single


class PizzaRepository : ProductNetworkService, SushiServices, DrinkServices {

    override fun getPizzas(): Single<List<ProductObject>> = Single.fromCallable {
        Thread.sleep(2000)
        PizzaData.listOfPizza
    }

    override fun pizza(id: Long): Single<ProductObject> = Single.fromCallable {
        Thread.sleep(2000)
        PizzaData.listOfPizza[id.toInt()]
    }
    override fun getSushi(): Single<List<ProductObject>> = Single.fromCallable {
        Thread.sleep(2000)
        SushiData.listOfSushi
    }

    override fun sushi(id: Long): Single<ProductObject> = Single.fromCallable {
        Thread.sleep(2000)
        SushiData.listOfSushi[id.toInt()]
    }

    override fun getDrinks(): Single<List<ProductObject>> = Single.fromCallable {
        Thread.sleep(2000)
        DrinkData.listOfDrinks
    }

    override fun drink(id: Long): Single<ProductObject> = Single.fromCallable {
        Thread.sleep(2000)
        DrinkData.listOfDrinks[id.toInt()]
    }
}