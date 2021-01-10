package com.darothub.dindinnui.repository

import com.darothub.dindinnui.model.ProductObject
import io.reactivex.Observable
import io.reactivex.Single

interface ProductNetworkService {

    fun getPizzas(): Single<List<ProductObject>>
    fun pizza(id:Long):Single<ProductObject>

}

interface SushiServices{
    fun getSushi():Single<List<ProductObject>>
    fun sushi(id:Long):Single<ProductObject>

}
interface  DrinkServices{
    fun getDrinks():Single<List<ProductObject>>
    fun drink(id:Long):Single<ProductObject>
}