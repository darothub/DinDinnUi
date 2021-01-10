package com.darothub.dindinnui.di

import android.app.Application
import com.darothub.dindinnui.repository.PizzaRepository

class DinDinnApplication : Application(){
    val networkService = PizzaRepository()
}
