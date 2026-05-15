package com.example.marketplace.ui.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.marketplace.model.Product
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductScreen(onBack: () -> Unit, onSubmit: (Product) -> Unit) {
    var nama by remember { mutableStateOf("") }
    var harga by remember { mutableStateOf("") }
    var stok by remember { mutableStateOf("") }
    var deskripsi by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("Books") }
    var isLoading by remember { mutableStateOf(false) }
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            selectedImageUri = uri
        }
    )

    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    val primaryColor = MaterialTheme.colorScheme.primary
    val secondaryColor = MaterialTheme.colorScheme.secondary
    val bgColor = MaterialTheme.colorScheme.background
    val surfaceColor = MaterialTheme.colorScheme.surface
    val inputBgColor = Color(0xFFF8F9FA)

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Add Product", fontWeight = FontWeight.Bold, fontSize = 18.sp) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = bgColor)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(bgColor)
                .padding(innerPadding)
                .verticalScroll(scrollState)
                .padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(surfaceColor)
                    .border(1.dp, primaryColor.copy(alpha = 0.2f), RoundedCornerShape(16.dp))
                    .clickable {
                        photoPickerLauncher.launch(
                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                        )
                    },
                contentAlignment = Alignment.Center
            ) {
                if (selectedImageUri != null) {
                    AsyncImage(
                        model = selectedImageUri,
                        contentDescription = "Selected Product Photo",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.Default.Add, contentDescription = "Upload", tint = primaryColor, modifier = Modifier.size(32.dp))
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Upload Product Photo", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = primaryColor)
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
            Text(text = "Product Information", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(16.dp))

            Text("Product Name", fontWeight = FontWeight.Medium, fontSize = 14.sp, color = Color.DarkGray)
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = nama, onValueChange = { nama = it },
                placeholder = { Text("e.g. Calculus Textbook", color = Color.Gray, fontSize = 14.sp) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = inputBgColor,
                    focusedBorderColor = primaryColor,
                    unfocusedBorderColor = Color.Transparent
                ),
                shape = RoundedCornerShape(16.dp), singleLine = true, modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Column(modifier = Modifier.weight(1f)) {
                    Text("Price (Rp)", fontWeight = FontWeight.Medium, fontSize = 14.sp, color = Color.DarkGray)
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = harga, onValueChange = { harga = it },
                        placeholder = { Text("75000", color = Color.Gray, fontSize = 14.sp) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = inputBgColor,
                            focusedBorderColor = primaryColor,
                            unfocusedBorderColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(16.dp), singleLine = true, modifier = Modifier.fillMaxWidth()
                    )
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text("Initial Stock", fontWeight = FontWeight.Medium, fontSize = 14.sp, color = Color.DarkGray)
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = stok, onValueChange = { stok = it },
                        placeholder = { Text("e.g. 15", color = Color.Gray, fontSize = 14.sp) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = inputBgColor,
                            focusedBorderColor = primaryColor,
                            unfocusedBorderColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(16.dp), singleLine = true, modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text("Short Description", fontWeight = FontWeight.Medium, fontSize = 14.sp, color = Color.DarkGray)
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = deskripsi, onValueChange = { deskripsi = it },
                placeholder = { Text("Condition, features, or other details...", color = Color.Gray, fontSize = 14.sp) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = inputBgColor,
                    focusedBorderColor = primaryColor,
                    unfocusedBorderColor = Color.Transparent
                ),
                shape = RoundedCornerShape(16.dp), minLines = 4, modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(32.dp))
            Text(text = "Category", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(16.dp))

            val categoriesRow1 = listOf("Books" to Icons.AutoMirrored.Filled.List, "Apparel" to Icons.Default.Person, "Electronics" to Icons.Default.Phone)
            val categoriesRow2 = listOf("Stationery" to Icons.Default.Edit, "Bags" to Icons.Default.ShoppingCart, "Others" to Icons.Default.Add)

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                categoriesRow1.forEach { (catName, icon) ->
                    CategoryItem(
                        name = catName,
                        icon = icon,
                        isSelected = selectedCategory == catName,
                        activeBg = primaryColor,
                        inactiveBg = surfaceColor,
                        iconBgColor = secondaryColor,
                        modifier = Modifier.weight(1f)
                    ) { selectedCategory = catName }
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                categoriesRow2.forEach { (catName, icon) ->
                    CategoryItem(
                        name = catName,
                        icon = icon,
                        isSelected = selectedCategory == catName,
                        activeBg = primaryColor,
                        inactiveBg = surfaceColor,
                        iconBgColor = secondaryColor,
                        modifier = Modifier.weight(1f)
                    ) { selectedCategory = catName }
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {
                    if (nama.isNotEmpty() && harga.isNotEmpty() && stok.isNotEmpty()) {
                        isLoading = true
                        coroutineScope.launch {
                            delay(1500)
                            isLoading = false
                            val parsedPrice = harga.toIntOrNull() ?: 0
                            val parsedStock = stok.toIntOrNull() ?: 0

                            onSubmit(
                                Product(
                                    name = nama,
                                    price = parsedPrice,
                                    description = deskripsi,
                                    category = selectedCategory,
                                    stock = parsedStock,
                                    rating = 0.0,
                                    reviewCount = 0,
                                    imageUri = selectedImageUri?.toString()
                                )
                            )
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth().height(54.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = secondaryColor),
                enabled = !isLoading
            ) {
                if (isLoading) {
                    CircularProgressIndicator(color = Color.White, modifier = Modifier.size(24.dp))
                } else {
                    Text("Save", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
                }
            }
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}

@Composable
fun CategoryItem(
    name: String,
    icon: ImageVector,
    isSelected: Boolean,
    activeBg: Color,
    inactiveBg: Color,
    iconBgColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val cardBgColor = if (isSelected) activeBg else inactiveBg
    val textColor = if (isSelected) Color.White else Color.DarkGray

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(cardBgColor)
            .clickable { onClick() }
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(iconBgColor, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = name,
                    tint = Color(0xFF222222),
                    modifier = Modifier.size(20.dp)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = name,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = textColor
            )
        }
    }
}