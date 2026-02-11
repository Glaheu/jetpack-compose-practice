package com.example.expensetracker.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.expensetracker.model.Category
import com.example.expensetracker.model.Transaction
import java.time.LocalDate

object TransactionDataSource {
    @RequiresApi(Build.VERSION_CODES.O)
    val transactionData = listOf(
        Transaction(
            id = 1L,
            amount = 30.0,
            date = LocalDate.of(2026, 2, 5), // Year, Month, Day
            category = Category.FOOD
        ),
        Transaction(
            id = 2L,
            amount = 25.30,
            date = LocalDate.of(2026, 2, 4), // Year, Month, Day
            category = Category.TRANSPORT
        ),
        Transaction(
            id = 3L,
            amount = 28.0,
            date = LocalDate.of(2026, 2, 3), // Year, Month, Day
            category = Category.FOOD
        ),
        Transaction(
            id = 4L,
            amount = 22.0,
            date = LocalDate.of(2026, 2, 1), // Year, Month, Day
            category = Category.BOOKS
        ),
        Transaction(
            id = 5L,
            amount = 10.0,
            date = LocalDate.of(2026, 1, 28), // Year, Month, Day
            category = Category.TRANSPORT
        ),
        Transaction(
            id = 6L,
            amount = 70.50,
            date = LocalDate.of(2026, 1, 25), // Year, Month, Day
            category = Category.HEALTH
        ),
    )
}