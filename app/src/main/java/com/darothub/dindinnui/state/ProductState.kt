package com.darothub.dindinnui.state

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.PersistState
import com.airbnb.mvrx.Uninitialized
import com.darothub.dindinnui.model.ProductObject

data class ProductState(
    val products: Async<List<ProductObject>> = Uninitialized,
    val product: ProductObject? = null,
    @PersistState val cartItems: List<ProductObject> = arrayListOf()
) : MvRxState
