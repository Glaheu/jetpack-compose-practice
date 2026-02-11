package com.example.expensetracker.model

data class TransactionUiState(
    val transactionList: List<Transaction> = emptyList()
) {
    val totalExpense get() = transactionList.sumOf { it.amount }
}