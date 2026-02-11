package com.example.expensetracker.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.expensetracker.model.TransactionUiState

@Composable
fun AddTransactionScreen(
    id: Long,
    viewModel: AddTransactionViewModel,
) {
    val uiState = viewModel.addTransactionUiState.collectAsState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        modifier = Modifier.fillMaxSize()
    ) {
        TextField(
            value = uiState.value.name,
            label = { Text(text = "name") },
            onValueChange = viewModel::nameTextbox,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            )
        )
        TextField(
            value = uiState.value.amountInput, // Use the String version from state
            onValueChange = viewModel::amountTextbox,
            label = { Text(text = "Amount") },
            prefix = { Text("$") },
            // Force the numeric keyboard to show up
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Done
            )
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun PreviewTransaction() {
    val viewModel: AddTransactionViewModel = viewModel()
    MaterialTheme {
        AddTransactionScreen(
            id = 1L,
            viewModel = viewModel
        )
    }
}