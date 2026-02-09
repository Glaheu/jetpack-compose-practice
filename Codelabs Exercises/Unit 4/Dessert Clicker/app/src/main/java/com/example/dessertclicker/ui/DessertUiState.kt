package com.example.dessertclicker.ui

import androidx.annotation.DrawableRes

data class DessertUiState(
    @DrawableRes val imageId: Int = 0,
    val dessertClicked: Int = 0,
    val totalRevenue: Int = 0
)
