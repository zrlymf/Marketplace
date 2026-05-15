package com.example.marketplace.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.marketplace.ui.screens.AddProductScreen
import com.example.marketplace.ui.screens.HomeScreen
import com.example.marketplace.ui.screens.ProfileScreen
import com.example.marketplace.viewmodel.MarketViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarketSiswaApp(
    viewModel: MarketViewModel = viewModel()
) {
    var currentScreen by remember { mutableStateOf("home") }
    var selectedTab by remember { mutableIntStateOf(0) }
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    val primaryColor = MaterialTheme.colorScheme.primary
    val secondaryColor = MaterialTheme.colorScheme.secondary
    val bgColor = MaterialTheme.colorScheme.background

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = {
        },
        bottomBar = {
            if (currentScreen != "add_product") {
                NavigationBar(
                    containerColor = bgColor,
                    tonalElevation = 8.dp
                ) {
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                        label = { Text("Home") },
                        selected = selectedTab == 0,
                        onClick = { selectedTab = 0; currentScreen = "home" },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF222222),
                            selectedTextColor = primaryColor,
                            indicatorColor = secondaryColor,
                            unselectedIconColor = Color.Gray,
                            unselectedTextColor = Color.Gray
                        )
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
                        label = { Text("Profile") },
                        selected = selectedTab == 1,
                        onClick = { selectedTab = 1; currentScreen = "profile" },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF222222),
                            selectedTextColor = primaryColor,
                            indicatorColor = secondaryColor,
                            unselectedIconColor = Color.Gray,
                            unselectedTextColor = Color.Gray
                        )
                    )
                }
            }
        },
        floatingActionButton = {
            if (currentScreen == "home") {
                FloatingActionButton(
                    onClick = { currentScreen = "add_product" },
                    containerColor = primaryColor,
                    contentColor = Color.White,
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "Add")
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(
                bottom = if (currentScreen != "add_product") innerPadding.calculateBottomPadding() else 0.dp,
                top = 0.dp
            )
        ) {
            when (currentScreen) {
                "home" -> HomeScreen(products = viewModel.products)

                "add_product" -> AddProductScreen(
                    onBack = { currentScreen = "home" },
                    onSubmit = { newProduct ->
                        coroutineScope.launch {
                            currentScreen = "home"
                            viewModel.addProduct(newProduct)
                            snackbarHostState.showSnackbar("✓ Product added successfully")
                        }
                    }
                )
                "profile" -> ProfileScreen()
            }
        }
    }
}