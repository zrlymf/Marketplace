package com.example.marketplace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.marketplace.ui.navigation.MarketSiswaApp
import com.example.marketplace.ui.theme.MarketplaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = android.graphics.Color.parseColor("#3A7E64")

        setContent {
            MarketplaceTheme {
                MarketSiswaApp()
            }
        }
    }
}