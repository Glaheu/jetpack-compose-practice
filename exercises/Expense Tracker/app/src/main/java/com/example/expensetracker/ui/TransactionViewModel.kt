package com.example.expensetracker.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import com.example.expensetracker.data.TransactionDataSource
import com.example.expensetracker.model.TransactionUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@RequiresApi(Build.VERSION_CODES.O)
class TransactionViewModel: ViewModel() {
    private val _transactionUiState = MutableStateFlow(TransactionUiState())
    val transactionUiState = _transactionUiState.asStateFlow()

    init {
        val transactionData = TransactionDataSource.transactionData
        _transactionUiState.update { it.copy(transactionList = transactionData) }
    }


}