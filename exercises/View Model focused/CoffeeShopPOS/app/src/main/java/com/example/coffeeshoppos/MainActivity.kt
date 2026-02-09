package com.example.coffeeshoppos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffeeshoppos.ui.theme.CoffeeShopPOSTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coffeeshoppos.model.MenuItem
import com.example.coffeeshoppos.model.OrderItem
import com.example.coffeeshoppos.ui.ShopViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoffeeShopPOSTheme {
                CoffeeShopScreen()
            }
        }
    }
}

@Composable
fun CoffeeShopScreen(viewModel: ShopViewModel = viewModel<ShopViewModel>()) {
    val state by viewModel.shopUiState.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text("Coffee Shop Menu", style = MaterialTheme.typography.headlineMedium)

        // 1. Menu List (The Input)
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(state.menu ?: emptyList()) { item ->
                MenuRow(item = item, onAdd = { viewModel.addItemToOrder(item) })
            }
        }

        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))

        // 2. Current Order (The State)
        Text("Current Order", style = MaterialTheme.typography.titleLarge)

        Box(modifier = Modifier.weight(1f)) {
            if (state.currentOrder.isEmpty()) {
                Text("No items in order", modifier = Modifier.align(Alignment.Center))
            } else {
                LazyColumn {
                    items(state.currentOrder) { orderItem ->
                        OrderRow(
                            orderItem = orderItem,
                            onRemove = { viewModel.removeItemFromOrder(orderItem.item) }
                        )
                    }
                }
            }
        }

        // 3. Checkout Summary (The Derived State)
        CheckoutSummary(
            subtotal = state.subtotal,
            tax = state.tax,
            total = state.total,
            onClear = { viewModel.clearOrder() },
            canCheckout = state.canCheckout
        )
    }
}

@Composable
fun MenuRow(item: MenuItem, onAdd: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(item.name, fontWeight = FontWeight.Bold)
            Text("$${String.format(java.util.Locale.US,"%.2f", item.price)}", fontSize = 14.sp)
        }
        IconButton(onClick = onAdd) {
            Icon(Icons.Default.Add, contentDescription = "Add to order")
        }
    }
}

@Composable
fun OrderRow(orderItem: OrderItem, onRemove: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("${orderItem.quantity}x ${orderItem.item.name}")
        IconButton(onClick = onRemove) {
            Icon(Icons.Default.Delete, contentDescription = "Remove", tint = Color.Gray)
        }
    }
}

@Composable
fun CheckoutSummary(
    subtotal: Double,
    tax: Double,
    total: Double,
    onClear: () -> Unit,
    canCheckout: Boolean
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
                Text("Subtotal")
                Text("$${String.format(java.util.Locale.US,"%.2f", subtotal)}")
            }
            Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
                Text("Tax (7%)")
                Text("$${String.format(java.util.Locale.US,"%.2f", tax)}")
            }
            Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
                Text(
                    "Total",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    "$${String.format(java.util.Locale.US,"%.2f", total)}",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedButton(onClick = onClear, modifier = Modifier.weight(1f)) {
                    Text("Clear")
                }
                Button(
                    onClick = { /* Checkout Logic */ },
                    enabled = canCheckout,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Checkout")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoffeeShopPOSTheme {
    }
}