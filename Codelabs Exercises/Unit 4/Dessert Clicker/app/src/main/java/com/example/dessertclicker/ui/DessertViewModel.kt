package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel() : ViewModel() {
    private val _dessertUiState = MutableStateFlow(DessertUiState())
    val dessertUiState = _dessertUiState.asStateFlow()

    private val dessertList = Datasource.dessertList

    init {
        _dessertUiState.update {
            it.copy(
                imageId = dessertList.first().imageId
            )
        }
    }

    fun determineDessertToShow(): Dessert {
        val dessertToShow =
            dessertList.findLast { it.startProductionAmount <= dessertUiState.value.dessertClicked }
                ?: dessertList.first()
        return dessertToShow
    }

    fun onDessertClicked() {
        val currentDessert = determineDessertToShow()
        _dessertUiState.update { currentState ->
            currentState.copy(
                imageId = currentDessert.imageId,
                dessertClicked = currentState.dessertClicked.inc(),
                totalRevenue = currentState.totalRevenue.plus(currentDessert.price)
            )
        }
    }
}