# Student Marketplace App

[![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack_Compose-4285F4?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com/jetpack/compose)
[![Material Design](https://img.shields.io/badge/Material_Design-757575?style=for-the-badge&logo=material-design&logoColor=white)](https://m3.material.io/)

> A modern, native Android marketplace application built specifically for college students to buy and sell campus essentials like textbooks, stationery, and electronics.

## Project Overview
This project is a native Android marketplace application tailored specifically for university students. Currently, the application serves as a robust Frontend UI/UX Showcase built entirely with Kotlin and Jetpack Compose. It demonstrates modern declarative UI principles, responsive state-driven layouts, and a custom design system, laying a solid and scalable groundwork for a full-fledged e-commerce platform.

Built entirely with **Jetpack Compose**, this application features a highly responsive, state-driven UI. The design system utilizes a custom color palette (Primary Green, Accent Yellow, and Terracotta) to deliver a fresh, engaging, and accessible user experience.

## Feature Highlights & UI Walkthrough

### 1. Dynamic Home & Product Discovery
The Home screen is designed for frictionless browsing, featuring dynamic category chips and promotional banners. 

| Feature | Description | Preview |
| :--- | :--- | :--- |
| **Category Filtering** | Users can easily filter the feed using interactive chips (All Products, Books, Apparel, Electronics, Stationery). | <img src="https://github.com/user-attachments/assets/20cd1a65-c79e-440f-b171-95218e48d8b0" width="250"> |
| **Featured Products** | Clean product cards displaying essential information: Price, Stock Left, and User Ratings. | <img src="https://github.com/user-attachments/assets/a9cfc8e9-9020-4af0-8aea-72e4e51224a7" width="250"> |
| **Interactive Cart State** | Seamless "Add to Cart" interactions with instant visual feedback via SnackBar ("✓ Product added successfully"). | <img src="https://github.com/user-attachments/assets/7b8b99fe-90f3-4006-a9ef-e8cf3f768023" width="250"> |

### 2. Seamless Product Management (CRUD)
A dedicated flow for sellers to easily list their items on the marketplace.

| Feature | Description | Preview |
| :--- | :--- | :--- |
| **Add New Product** | Intuitive form for uploading product photos, setting prices, and defining initial stock. | <img src="https://github.com/user-attachments/assets/131f044b-58e9-496d-bd29-528731568d8a" width="250"> |
| **Categorization** | Sellers can select appropriate categories via interactive icon-based toggle buttons (e.g., selecting 'Electronics' or 'Stationery'). | <img src="https://github.com/user-attachments/assets/d6dd0d69-6d22-4270-9e0b-601eb148cbaa" width="250"> |

### 3. Personalized User Dashboard
The Profile section acts as a command center for users to track their marketplace activity.

| Feature | Description | Preview |
| :--- | :--- | :--- |
| **Activity Overview** | Quick statistical overview of the user's performance: items **On Sale**, items **Sold**, and **Favorites**. | <img src="https://github.com/user-attachments/assets/1c1ec0d4-0cd8-4e27-9626-a01c284c7fc0" width="250"> |
| **Quick Actions** | Easy access to manage owned products, read messages/chats (with unread badges), and adjust account settings. | *(Refer to Profile image)* |

## Tech Stack & Architecture
*   **UI Toolkit:** Jetpack Compose (100% Kotlin-based declarative UI).
*   **Architecture:** Model-View-ViewModel (MVVM) to ensure a clean separation of concerns between UI and business logic.
*   **Navigation:** Jetpack Compose Navigation for seamless screen transitions.
*   **State Management:** `StateFlow` and `ViewModel` for reactive state updates across the app.
*   **Image Loading:** Coil (optimized for Compose) to efficiently render UI assets and placeholders.

## Future Improvements
Since the current iteration focuses heavily on establishing a clean frontend architecture and seamless user interface, the next development phases will focus on integrating backend logic and bringing the static screens to life:

*   **Backend & Database Integration:** Connecting the app to Firebase or a custom REST API to fetch real product data and handle user authentication.
*   **Functional Cart & Checkout Flow:** Implementing the logic behind the cart icon to allow users to calculate totals and process mock payments.
*   **Real-Time Messaging:** Activating the "Messages & Chat" feature in the Profile section to facilitate communication between buyers and sellers.
*   **Search & Filtering Logic:** Making the search bar and category chips fully functional to query specific products from the database.

---
