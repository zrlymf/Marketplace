package com.example.marketplace.viewmodel

import androidx.compose.runtime.mutableStateListOf
import com.example.marketplace.R
import androidx.lifecycle.ViewModel
import com.example.marketplace.model.Product

class MarketViewModel : ViewModel() {
    private val _products = mutableStateListOf(
        Product(
            name = "Math Textbook Vol 1",
            price = 75000,
            description = "Advanced mathematics for students.",
            category = "Books",
            stock = 12,
            rating = 4.8,
            reviewCount = 120,
            imageRes = R.drawable.math_textbook
        ),
        Product(
            name = "Wireless Mouse",
            price = 125000,
            description = "Ergonomic mouse for e-learning.",
            category = "Electronics",
            stock = 5,
            rating = 4.5,
            reviewCount = 89,
            imageRes = R.drawable.mouse
        ),
        Product(
            name = "Physics Guide",
            price = 80000,
            description = "Complete physics formulas & concepts.",
            category = "Books",
            stock = 8,
            rating = 4.9,
            reviewCount = 210,
            imageRes = R.drawable.physics_guide
        ),
        Product(
            name = "Notebook 5-Pack",
            price = 25000,
            description = "A5 lined notebooks for everyday notes.",
            category = "Stationery",
            stock = 25,
            rating = 4.7,
            reviewCount = 304,
            imageRes = R.drawable.notebook
        )
    )

    val products: List<Product> = _products

    fun addProduct(newProduct: Product) {
        _products.add(0, newProduct)
    }
}