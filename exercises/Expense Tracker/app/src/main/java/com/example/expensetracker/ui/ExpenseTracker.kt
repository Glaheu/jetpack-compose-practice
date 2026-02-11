package com.example.expensetracker.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import com.example.expensetracker.R

@Serializable
sealed interface Titles {
    val titleResId: Int
}

@Serializable
data object DashboardScreen

@Serializable
data object AddTransaction : Titles {
    val id: Long = -1L
    override val titleResId: Int = R.string.add_transaction
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ExpenseTrackerApp() {
    val navController: NavHostController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar()
        },
        floatingActionButton = {
            FAButton({})
        },
        modifier = Modifier
    ) { innerPadding ->
        NavigationHost(
            navController = navController,
            modifier = Modifier.padding(
                innerPadding
            )
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val viewModel: TransactionViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = DashboardScreen,
        modifier = modifier
    ) {
        composable<DashboardScreen> {
            DashboardScreen(
                viewModel = viewModel,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar() {
    CenterAlignedTopAppBar(
        title = { Text("Expense Tracker") },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        )
    )
}

@Composable
fun FAButton(
    onClick: () -> Unit
) {
    ExtendedFloatingActionButton(
        onClick = onClick,
        icon = { Icon(imageVector = Icons.Filled.Edit, contentDescription = null) },
        text = { Text(text = "Add Transaction") }
    )
}