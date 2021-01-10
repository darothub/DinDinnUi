package com.darothub.dindinnui.viewmodel

import android.annotation.SuppressLint
import com.airbnb.mvrx.*
import com.darothub.dindinnui.app.DinDinnApp
import com.darothub.dindinnui.repository.Repository
import com.darothub.dindinnui.state.ProductState
import io.reactivex.schedulers.Schedulers.io


@SuppressLint("CheckResult")
class PizzaViewModel(
    state:ProductState,
    productNetworkService: Repository
): BaseMvRxViewModel<ProductState>(state, debugMode = true){

    init {
        productNetworkService.getPizzas()
            .subscribeOn(io())
            .execute { copy(products = it) }
    }

    companion object : MvRxViewModelFactory<PizzaViewModel, ProductState>{
        override fun create(
            viewModelContext: ViewModelContext,
            state: ProductState
        ): PizzaViewModel? {
            val productNetworkService = viewModelContext.app<DinDinnApp>().pizzaService
            return PizzaViewModel(state, productNetworkService)
        }

    }
}