package com.darothub.dindinnui.viewmodel

import android.annotation.SuppressLint
import com.airbnb.mvrx.*
import com.darothub.dindinnui.app.DinDinnApp
import com.darothub.dindinnui.repository.Repository
import com.darothub.dindinnui.state.ProductState
import io.reactivex.schedulers.Schedulers.io

@SuppressLint("CheckResult")
class DrinkViewModel(
    state: ProductState,
    productNetworkService: Repository
) : BaseMvRxViewModel<ProductState>(state, debugMode = true) {

    init {
        productNetworkService.getDrinks()
            .subscribeOn(io())
            .execute { copy(products = it) }
    }

    companion object : MvRxViewModelFactory<DrinkViewModel, ProductState> {
        override fun create(
            viewModelContext: ViewModelContext,
            state: ProductState
        ): DrinkViewModel? {
            val productNetworkService = viewModelContext.app<DinDinnApp>().pizzaService
            return DrinkViewModel(state, productNetworkService)
        }
    }
}
