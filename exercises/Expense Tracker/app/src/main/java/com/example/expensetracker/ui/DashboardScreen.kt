package com.example.expensetracker.ui

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SelectableChipElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expensetracker.model.Category
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.expensetracker.data.TransactionDataSource
import com.example.expensetracker.model.Transaction
import com.example.expensetracker.model.TransactionUiState
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import javax.sql.DataSource

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DashboardScreen(
    viewModel: TransactionViewModel,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.transactionUiState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
        ) {
            item {
                LazyRow() {
                    items(Category.entries.toTypedArray()) { category ->
                        CategoryTab(category, uiState, viewModel::filterCategory)
                    }
                }
            }
            items(uiState.transactionList) { transaction ->
                TrasactionCard(transaction)
            }
        }
    }
}

@SuppressLint("NewApi")
@Composable
fun TrasactionCard(
    transaction: Transaction,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(100.dp)
            .padding(vertical = 8.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxHeight()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
            ) {
                Text(
                    text = transaction.name,
                    modifier = Modifier.weight(1f),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = "$${transaction.amount}",
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
            ) {
                Text(
                    text = formatLocalDateToNormalDate(transaction.date).toString(),
                )
                Text(
                    text = transaction.category.toString(),
                )
            }
        }
    }
}

@Composable
fun CategoryTab(
    category: Category,
    uiState: TransactionUiState,
    filterCateogry: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    FilterChip(
        onClick = { filterCateogry(category) },
        selected = uiState.selectedCategory.contains(category),
        label = {
            Text(text = category.name)
        },
        leadingIcon = if (uiState.selectedCategory.contains(category)) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
        modifier = Modifier.padding(horizontal = 4.dp)
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun PreviewDashboard() {
    val viewModel: TransactionViewModel = viewModel()
    MaterialTheme {
        DashboardScreen(
            viewModel = viewModel,
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun formatLocalDateToNormalDate(date: LocalDate, pattern: String = "dd MMM yyyy"): String? {
    val formatter = DateTimeFormatter.ofPattern(pattern, Locale.getDefault())

    return date.format(formatter)
}