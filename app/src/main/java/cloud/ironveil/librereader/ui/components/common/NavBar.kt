package cloud.ironveil.librereader.ui.components.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import cloud.ironveil.librereader.R

// Main bottom navigation bar

@Composable
fun NavBar(
    navController: NavController,
    screen: String
) {

    // MD3 Navbar
    NavigationBar() {

        // Home button
        NavigationBarItem(
            icon = {
                Icon(
                    if (screen == "home") {
                        Icons.Filled.Home
                    } else {
                        Icons.Outlined.Home
                    },
                    contentDescription = stringResource(R.string.bottom_bar_home)
                )
            },

            label = {
                Text(text = stringResource(R.string.bottom_bar_home))
            },

            selected = screen == "home",

            onClick = { navController.navigate("home") {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }

                launchSingleTop = true
                restoreState = true
            } }
        )

        // Books button
        NavigationBarItem(
            icon = {
                Icon(
                    if (screen == "books") {
                          Icons.Filled.Book
                    } else {
                        Icons.Outlined.Book
                    },
                    contentDescription = stringResource(R.string.bottom_bar_books)
                )
            },

            label = {
                Text(text = stringResource(R.string.bottom_bar_books))
            },

            selected = screen == "books",

            onClick = { navController.navigate("books") {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }

                launchSingleTop = true
                restoreState = true
            } }
        )

        // Settings button
        NavigationBarItem(
            icon = {
                Icon(
                    if (screen == "settings") {
                        Icons.Filled.Settings
                    } else {
                        Icons.Outlined.Settings
                    },
                    contentDescription = stringResource(R.string.bottom_bar_settings)
                )
            },

            label = {
                Text(text = stringResource(R.string.bottom_bar_settings))
            },

            selected = screen == "settings",

            onClick = { navController.navigate("settings") {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }

                launchSingleTop = true
                restoreState = true
            } }
        )
    }
}