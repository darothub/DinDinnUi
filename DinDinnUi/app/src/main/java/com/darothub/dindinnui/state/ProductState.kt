package com.darothub.dindinnui.state

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import com.darothub.dindinnui.model.ProductObject

data class ProductState(
    val products: Async<List<ProductObject>> = Uninitialized,
    val productId:Long?= null
) : MvRxState{

    val productPurchased = product(productId)
    fun product(productId:Long?)=products()?.firstOrNull{it.id == productId}
}