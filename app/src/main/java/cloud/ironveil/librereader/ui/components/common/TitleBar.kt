package cloud.ironveil.librereader.ui.components.common

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.ui.res.stringResource
import cloud.ironveil.librereader.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleBar(
    navController: NavController,
    scrollBehavior: TopAppBarScrollBehavior
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val screen = navBackStackEntry?.destination?.route

    LargeTopAppBar (
        title = {
            if (screen == "home") {
                Text(stringResource(R.string.bottom_bar_home))
            } else if (screen == "books") {
                Text(stringResource(R.string.bottom_bar_books))
            } else if (screen == "settings") {
                Text(stringResource(R.string.bottom_bar_settings))
            }
        },
        scrollBehavior = scrollBehavior
    )
}