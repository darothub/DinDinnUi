package com.darothub.dindinnui.repository

import com.darothub.dindinnui.data.DrinkData
import com.darothub.dindinnui.data.PizzaData
import com.darothub.dindinnui.data.SushiData
import com.darothub.dindinnui.model.ProductObject
import io.reactivex.Observable


//class DrinkRepository : ProductNetworkService {
//    override fun getDrinks(): Observable<List<ProductObject>> = Observable.fromCallable {
//        Thread.sleep(2000)
//        DrinkData.listOfDrinks
//    }
//
//    override fun drink(id: Long): Observable<ProductObject> = Observable.fromCallable {
//        Thread.sleep(2000)
//        DrinkData.listOfDrinks[id.toInt()]
//    }
//}