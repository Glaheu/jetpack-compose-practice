/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.lunchtray

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lunchtray.datasource.DataSource
import com.example.lunchtray.model.MenuItem
import com.example.lunchtray.model.MenuItem.AccompanimentItem
import com.example.lunchtray.model.OrderUiState
import com.example.lunchtray.ui.AccompanimentMenuScreen
import com.example.lunchtray.ui.BaseMenuScreen
import com.example.lunchtray.ui.CheckoutScreen
import com.example.lunchtray.ui.OrderViewModel
import com.example.lunchtray.ui.SideDishMenuScreen
import com.example.lunchtray.ui.StartOrderScreen
import kotlinx.serialization.Serializable

// TODO: Screen enum

interface LunchTrayDestination {
    @get:StringRes
    val titleRes: Int
}


@Serializable
data object Start : LunchTrayDestination {
    override val titleRes: Int = R.string.app_name
}

@Serializable
object EntreeMenu : LunchTrayDestination {
    override val titleRes: Int = R.string.choose_entree
}

@Serializable
object SideDishMenu : LunchTrayDestination {
    override val titleRes: Int = R.string.choose_side_dish
}

@Serializable
object AccompanimentMenu : LunchTrayDestination {
    override val titleRes: Int = R.string.choose_accompaniment
}

@Serializable
object Checkout : LunchTrayDestination {
    override val titleRes: Int = R.string.order_checkout
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    @StringRes currentScreenTitle: Int,
    canNavigateUp: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = { Text(stringResource(currentScreenTitle)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateUp) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LunchTrayApp(
    navController: NavHostController = rememberNavController(),
) {

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = when (backStackEntry?.destination?.route) {
        Start::class.qualifiedName -> Start.titleRes
        EntreeMenu::class.qualifiedName -> EntreeMenu.titleRes
        SideDishMenu::class.qualifiedName -> SideDishMenu.titleRes
        AccompanimentMenu::class.qualifiedName -> AccompanimentMenu.titleRes
        Checkout::class.qualifiedName -> Checkout.titleRes
        else -> Start.titleRes
    }
    // Create ViewModel
    val viewModel: OrderViewModel = viewModel()
    Scaffold(
        topBar = {
            TopAppBar(
                currentScreenTitle = currentScreen,
                canNavigateUp = navController.previousBackStackEntry != null,
                navigateUp = { navController.popBackStack() }
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    innerPadding
                )
        ) {
            composable<Start> {
                StartOrderScreen(
                    onStartOrderButtonClicked = { navController.navigate(EntreeMenu) },
                    modifier = Modifier
                )
            }
            composable<EntreeMenu> {
                BaseMenuScreen(
                    options = DataSource.entreeMenuItems,
                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(
                            viewModel,
                            navController
                        )
                    },
                    onNextButtonClicked = { navController.navigate(SideDishMenu) },
                    onSelectionChanged =
                        { viewModel.updateEntree(it) },
                    modifier = Modifier.fillMaxSize(),
                )
            }
            composable<SideDishMenu> {
                SideDishMenuScreen(
                    options = DataSource.sideDishMenuItems,
                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(
                            viewModel,
                            navController
                        )
                    },
                    onNextButtonClicked = { navController.navigate(AccompanimentMenu) },
                    onSelectionChanged =
                        { viewModel.updateSideDish(it) },
                    modifier = Modifier
                )
            }
            composable<AccompanimentMenu> {
                AccompanimentMenuScreen(
                    options = DataSource.accompanimentMenuItems,
                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(
                            viewModel,
                            navController
                        )
                    },
                    onNextButtonClicked = { navController.navigate(Checkout) },
                    onSelectionChanged =
                        { viewModel.updateAccompaniment(it) },
                    modifier = Modifier
                )
            }
            composable<Checkout> {
                CheckoutScreen(
                    orderUiState = uiState,
                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(
                            viewModel,
                            navController
                        )
                    },
                    onNextButtonClicked = {
                        cancelOrderAndNavigateToStart(
                            viewModel,
                            navController
                        )
                    },
                    modifier = Modifier
                )
            }
        }
    }
}

private fun cancelOrderAndNavigateToStart(
    viewModel: OrderViewModel,
    navController: NavHostController
) {
    viewModel.resetOrder()
    navController.popBackStack(Start, inclusive = false)
}
