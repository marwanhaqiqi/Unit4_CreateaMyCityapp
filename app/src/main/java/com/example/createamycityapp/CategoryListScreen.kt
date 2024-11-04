package com.example.createamycityapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryListScreen(navController: NavController, viewModel: PlaceViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("My City") })
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            items(viewModel.getCategories()) { category ->
                Text(
                    text = category,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {
                            navController.navigate("place_list/$category")
                        },
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}
