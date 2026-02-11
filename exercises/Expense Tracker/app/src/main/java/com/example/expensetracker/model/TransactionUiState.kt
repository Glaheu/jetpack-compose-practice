package com.example.expensetracker.model

data class TransactionUiState(
    val transactionList: List<Transaction> = emptyList(),
    val selectedCategory: List<Category> = emptyList()
) {
    val totalExpense get() = transactionList.sumOf { it.amount }
}