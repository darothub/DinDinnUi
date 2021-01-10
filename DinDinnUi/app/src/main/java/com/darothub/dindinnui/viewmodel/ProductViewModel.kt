package com.darothub.dindinnui.viewmodel

import android.annotation.SuppressLint
import com.airbnb.mvrx.*
import com.darothub.dindinnui.app.DinDinnApp
import com.darothub.dindinnui.repository.ProductNetworkService
import com.darothub.dindinnui.state.ProductState
import io.reactivex.schedulers.Schedulers.io


@SuppressLint("CheckResult")
class ProductViewModel(
    state:ProductState,
    productNetworkService: ProductNetworkService
): BaseMvRxViewModel<ProductState>(state, debugMode = true){

    init {
        productNetworkService.getPizzas()
            .subscribeOn(io())
            .execute { copy(products = it) }

    }

    companion object : MvRxViewModelFactory<ProductViewModel, ProductState>{
        override fun create(
            viewModelContext: ViewModelContext,
            state: ProductState
        ): ProductViewModel? {
            val productNetworkService = viewModelContext.app<DinDinnApp>().networkService
            return ProductViewModel(state, productNetworkService)
        }

    }
}