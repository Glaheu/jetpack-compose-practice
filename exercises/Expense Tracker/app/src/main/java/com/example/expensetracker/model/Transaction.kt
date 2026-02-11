package com.example.expensetracker.model

import java.time.LocalDate

data class Transaction(
    val id: Long = 0,
    val amount: Double,
    val date: LocalDate,
    val category: Category
)

