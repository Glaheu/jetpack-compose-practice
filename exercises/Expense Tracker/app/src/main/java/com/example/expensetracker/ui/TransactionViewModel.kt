package com.example.expensetracker.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import com.example.expensetracker.data.TransactionDataSource
import com.example.expensetracker.model.Category
import com.example.expensetracker.model.TransactionUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@RequiresApi(Build.VERSION_CODES.O)
class TransactionViewModel : ViewModel() {
    private val _transactionUiState = MutableStateFlow(TransactionUiState())
    val transactionUiState = _transactionUiState.asStateFlow()

    init {
        val transactionData = TransactionDataSource.transactionData
        _transactionUiState.update { it.copy(transactionList = transactionData) }
    }

    fun filterCategory(selectedCategory: Category) {
        _transactionUiState.update { currentState ->
            val checkIfSelected = currentState.selectedCategory.find { it == selectedCategory }
            if (checkIfSelected == null) {
                val addedCategoryToList = currentState.selectedCategory + selectedCategory
                currentState.copy(selectedCategory = addedCategoryToList)
            } else {
                val removedCategoryFromList =
                    currentState.selectedCategory.filter { it != selectedCategory }
                currentState.copy(selectedCategory = removedCategoryFromList)
            }
        }
    }
}