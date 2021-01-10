package com.darothub.dindinnui.repository

import com.darothub.dindinnui.data.ProductData
import com.darothub.dindinnui.model.ProductObject
import io.reactivex.Observable


class PizzaRepository : ProductNetworkService {

    override fun getPizzas(): Observable<List<ProductObject>> = Observable.fromCallable {
        Thread.sleep(2000)
        ProductData.listOfObject
    }

    override fun pizza(id: Long): Observable<ProductObject> = Observable.fromCallable {
        Thread.sleep(2000)
        ProductData.listOfObject[id.toInt()]
    }
}