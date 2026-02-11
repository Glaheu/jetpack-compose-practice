package com.example.expensetracker.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.expensetracker.model.Category
import androidx.lifecycle.viewmodel.compose.viewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DashboardScreen(
    viewModel: TransactionViewModel,
    onShowCategoryClick: () -> Unit,
    onShowTransactionClick: () -> Unit,
    onCategoryClick: (Category) -> Unit,
    onAddTransactionClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val UiState by viewModel.transactionUiState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun PreviewDashboard() {
    val viewModel: TransactionViewModel = viewModel()
    MaterialTheme {
        DashboardScreen(
            viewModel = viewModel,
            onShowCategoryClick = {},
            onShowTransactionClick = {},
            onCategoryClick = {},
            onAddTransactionClick = {},
        )
    }
}