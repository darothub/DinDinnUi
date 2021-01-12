package com.darothub.dindinnui.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import com.airbnb.mvrx.*
import com.darothub.dindinnui.app.DinDinnApp
import com.darothub.dindinnui.data.CartData
import com.darothub.dindinnui.model.ProductObject
import com.darothub.dindinnui.repository.Repository
import com.darothub.dindinnui.state.ProductState
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
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
    fun remove(id: Int){
        setState { copy(addProduct = addProduct.dropLast(1)) }
    }
    fun addItem(productObject: ProductObject){
        repository.addToCart(productObject)

    }

    fun adding(productObject: ProductObject){
        setState { copy(addProduct = arrayListOf(productObject) + addProduct) }
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