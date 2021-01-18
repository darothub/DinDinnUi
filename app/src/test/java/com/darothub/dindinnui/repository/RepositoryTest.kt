package com.darothub.dindinnui.repository

import com.darothub.dindinnui.data.PizzaData
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class RepositoryTest {

    private val repository: Repository = Repository()

    @Test
    fun testGetPizzas() {
        assert(repository.getPizzas().blockingGet() == PizzaData.listOfPizza)
    }
}
