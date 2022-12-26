package com.adisalagic.shikicinema

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.adisalagic.shikicinema.ui.navigations.ScreenLibrary
import com.adisalagic.shikicinema.ui.navigations.ScreenSearch

sealed class NavigationItem(val name: String, val path: String, @DrawableRes val icon: Int) {
    object Library : NavigationItem("Library", "library", R.drawable.ic_baseline_local_library_24)
    object Search : NavigationItem("Search", "search", R.drawable.ic_baseline_search_24)
}

object Navigation {
    val navigationList = listOf(
        NavigationItem.Library,
        NavigationItem.Search
    )
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Library.path,
    ) {
        composable(NavigationItem.Library.path){
            ScreenLibrary()
        }
        composable(NavigationItem.Search.path){
            ScreenSearch()
        }
    }
}