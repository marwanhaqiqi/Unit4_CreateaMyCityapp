package com.example.createamycityapp

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceDetailScreen(navController: NavController, placeName: String, viewModel: PlaceViewModel) {
    val place = viewModel.getPlacesForCategory("").find { it.name == placeName }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(placeName) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        place?.let {
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
            ) {
                Text(text = it.description, style = MaterialTheme.typography.bodyLarge)
                // Add additional image or content here if needed
            }
        } ?: run {
            // Handle the case where the place is not found
            Text(text = "Place not found", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
