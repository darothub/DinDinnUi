package com.darothub.dindinnui.app

import android.app.Application
import com.darothub.dindinnui.repository.Repository

class DinDinnApp : Application() {
    val pizzaService by lazy {
        Repository()
    }
}
