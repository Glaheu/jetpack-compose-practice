package com.example.expensetracker.model

import java.time.LocalDate

data class AddTransactionUiState(
    val id: Long = 0,
    val name: String = "",
    val amountInput: String = "",
    val amount: Double = 0.0,
    val date: LocalDate? = null,
    val category: Category? = null
)
