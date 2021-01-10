package com.darothub.dindinnui.repository

import com.darothub.dindinnui.model.ProductObject
import io.reactivex.Observable

interface ProductNetworkService {

    fun getPizzas():Observable<List<ProductObject>> = TODO()
    fun pizza(id:Long):Observable<ProductObject> = TODO()
}