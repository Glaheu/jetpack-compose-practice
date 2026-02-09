package com.example.coffeeshoppos.ui

import android.view.Menu
import androidx.lifecycle.ViewModel
import com.example.coffeeshoppos.data.CoffeeDataSource
import com.example.coffeeshoppos.model.MenuItem
import com.example.coffeeshoppos.model.OrderItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ShopViewModel: ViewModel() {
    private val _shopUiState = MutableStateFlow(ShopUiState())
    val shopUiState = _shopUiState.asStateFlow()

    init {
        val menuData = CoffeeDataSource().getMenu()
        _shopUiState.update {
            it.copy(
                menu = menuData
            )
        }
    }

    fun addItemToOrder(item: MenuItem) {
        _shopUiState.update { currentState ->
            val itemExistsInOrder = currentState.currentOrder.any { it.item.name == item.name }
            if (itemExistsInOrder) {
                //inc by 1
                val addedToOrder = currentState.currentOrder.map { currentItem ->
                    if (currentItem.item.name == item.name) {
                        currentItem.copy(
                            quantity = currentItem.quantity.inc()
                        )
                    } else {
                        currentItem
                    }
                }
                currentState.copy(
                    currentOrder = addedToOrder
                )
            } else {
                val addItemToList = currentState.currentOrder + OrderItem(item = item, quantity = 1)
                currentState.copy(
                    currentOrder = addItemToList
                )
            }
        }
    }

    fun removeItemFromOrder(item: MenuItem) {
        _shopUiState.update { currentState ->
            val itemInOrder = currentState.currentOrder.find { it.item.name == item.name }
            if (itemInOrder != null && itemInOrder.quantity > 1) {
                val decrementQuantityInOrder = currentState.currentOrder.map {
                    if (it.item.name == item.name)
                        it.copy(quantity = it.quantity.dec())
                    else
                        it
                }
                currentState.copy(
                    currentOrder = decrementQuantityInOrder
                )
            } else {
                val removeItem = currentState.currentOrder.filter { it.item.name != item.name }
                currentState.copy(
                    currentOrder = removeItem
                )
            }
        }
    }

    fun clearOrder() {
        _shopUiState.update { currentState ->
            currentState.copy(
                currentOrder = emptyList()
            )
        }
    }
}