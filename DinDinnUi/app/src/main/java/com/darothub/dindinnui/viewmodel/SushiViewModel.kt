package com.darothub.dindinnui.viewmodel

import android.annotation.SuppressLint
import com.airbnb.mvrx.*
import com.darothub.dindinnui.app.DinDinnApp
import com.darothub.dindinnui.repository.PizzaRepository
import com.darothub.dindinnui.repository.ProductNetworkService
import com.darothub.dindinnui.state.ProductState
import io.reactivex.schedulers.Schedulers.io


@SuppressLint("CheckResult")
class SushiViewModel(
    state:ProductState,
    productNetworkService: PizzaRepository
): BaseMvRxViewModel<ProductState>(state, debugMode = true){

    init {
        productNetworkService.getSushi()
            .subscribeOn(io())
            .execute { copy(products = it) }
    }

    companion object : MvRxViewModelFactory<SushiViewModel, ProductState>{
        override fun create(
            viewModelContext: ViewModelContext,
            state: ProductState
        ): SushiViewModel? {
            val productNetworkService = viewModelContext.app<DinDinnApp>().pizzaService
            return SushiViewModel(state, productNetworkService)
        }

    }
}