package com.darothub.dindinnui.repository

import android.app.Application
import com.darothub.dindinnui.app.DinDinnApp
import com.darothub.dindinnui.data.PizzaData
import io.reactivex.Observable
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class RepositoryTest  {


    private val repository: Repository = Repository()

    @Test
    fun testGetPizzas() {
        assert(repository.getPizzas().blockingGet() == PizzaData.listOfPizza)
    }
}