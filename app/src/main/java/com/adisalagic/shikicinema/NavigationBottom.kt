package com.adisalagic.shikicinema

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun NavigationBottom(navController: NavHostController) {
    NavigationBar() {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        Navigation.navigationList.forEach {
            NavigationBarItem(selected = currentRoute == it.path, onClick = {
                navController.navigate(it.path) {
                    navController.graph.startDestinationRoute?.let { screen_route ->
                        popUpTo(screen_route) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
                icon = {
                    Icon(
                        painter = painterResource(id = it.icon),
                        contentDescription = it.name
                    )
                },
            label = {
                Text(text = it.name)
            })
        }
    }
}