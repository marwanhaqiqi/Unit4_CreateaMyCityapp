package com.example.createamycityapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


sealed class Screen(val route: String) {
    object CategoryList : Screen("category_list")
    object PlaceList : Screen("place_list/{category}")
    object PlaceDetail : Screen("place_detail/{placeName}")
}

@Composable
fun NavGraph(navController: NavHostController, placeViewModel: PlaceViewModel) {
    NavHost(navController = navController, startDestination = Screen.CategoryList.route) {
        composable(Screen.CategoryList.route) {
            CategoryListScreen(navController, placeViewModel)
        }
        composable(Screen.PlaceList.route) { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category") ?: ""
            PlaceListScreen(navController, category, placeViewModel)
        }
        composable(Screen.PlaceDetail.route) { backStackEntry ->
            val placeName = backStackEntry.arguments?.getString("placeName") ?: ""
            PlaceDetailScreen(navController, placeName, placeViewModel) // Ensure this function is defined
        }
    }
}

