package com.example.expensetracker.ui

import androidx.lifecycle.ViewModel
import com.example.expensetracker.model.AddTransactionUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AddTransactionViewModel : ViewModel() {
    private val _addTransactionUiState = MutableStateFlow(AddTransactionUiState())
    val addTransactionUiState = _addTransactionUiState.asStateFlow()

    fun nameTextbox(string: String) {
        _addTransactionUiState.update { currentState ->
            currentState.copy(name = string)
        }
    }

    fun amountTextbox(amount: String) {
        val isValidInput =
            amount.isEmpty() || amount.all { it.isDigit() || it == '.' } && amount.count { it == '.' } <= 1
        if (isValidInput) {
            _addTransactionUiState.update { currentState ->
                currentState.copy(
                    amount = amount.toDoubleOrNull() ?: 0.0,
                    amountInput = amount
                )
            }
        }
    }

}