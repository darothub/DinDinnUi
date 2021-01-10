package com.darothub.dindinnui.app

import android.app.Application
import com.darothub.dindinnui.repository.PizzaRepository

class DinDinnApp : Application(){
    val pizzaService by lazy {
       PizzaRepository()
    }
}
