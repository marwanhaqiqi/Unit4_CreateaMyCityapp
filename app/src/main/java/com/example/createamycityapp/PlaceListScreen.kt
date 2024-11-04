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
fun PlaceListScreen(navController: NavController, category: String, viewModel: PlaceViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(category) })
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            items(viewModel.getPlacesForCategory(category)) { place ->
                Text(
                    text = place.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {
                            navController.navigate("place_detail/${place.name}")
                        },
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}
