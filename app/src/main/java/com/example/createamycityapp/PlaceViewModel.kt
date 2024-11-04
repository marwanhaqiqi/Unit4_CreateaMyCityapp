package com.example.createamycityapp

import androidx.lifecycle.ViewModel

class PlaceViewModel : ViewModel() {

    private val places = mapOf(
        "Category1" to listOf(
            Place("Place 1", "Description of Place 1"),
            Place("Place 2", "Description of Place 2"),
            Place("Place 3", "Description of Place 3")
        ),
        "Category2" to listOf(
            Place("Place A", "Description of Place A"),
            Place("Place B", "Description of Place B"),
            Place("Place C", "Description of Place C")
        )
    )

    // Function to get categories
    fun getCategories(): List<String> {
        return places.keys.toList()  // Extracts the category names from the keys of the map
    }

    // Function to get places for a specific category
    fun getPlacesForCategory(category: String): List<Place> {
        return places[category] ?: emptyList()
    }
}
