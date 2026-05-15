package com.example.marketplace.model

import java.util.UUID

data class Product(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val price: Int,
    val description: String,
    val category: String,
    val stock: Int,
    val rating: Double,
    val reviewCount: Int,
    val imageRes: Int? = null,
    val imageUri: String? = null
)