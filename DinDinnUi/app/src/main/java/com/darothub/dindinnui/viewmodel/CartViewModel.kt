package com.darothub.dindinnui.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import com.airbnb.mvrx.*
import com.darothub.dindinnui.app.DinDinnApp
import com.darothub.dindinnui.model.ProductObject
import com.darothub.dindinnui.repository.Repository
import com.darothub.dindinnui.state.ProductState
import io.reactivex.schedulers.Schedulers.io


@SuppressLint("CheckResult")
class CartViewModel(
    state:ProductState,
    private val repository: Repository
): BaseMvRxViewModel<ProductState>(state, debugMode = true){

    init {
        repository.getCart()
            .subscribeOn(io())
            .execute { copy(products = it) }
    }

    fun removeItem(id:Int){
        repository.removeItemFromCart(id)

    }
    fun addItem(productObject: ProductObject){
        repository.addToCart(productObject)

    }

    companion object : MvRxViewModelFactory<CartViewModel, ProductState>{
        override fun create(
            viewModelContext: ViewModelContext,
            state: ProductState
        ): CartViewModel? {
            val productNetworkService = viewModelContext.app<DinDinnApp>().pizzaService
            return CartViewModel(state, productNetworkService)
        }

    }
}