package cloud.ironveil.librereader.ui.components.common

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import cloud.ironveil.librereader.R

// Main big titlebar for the main sections

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleBar(
    scrollBehavior: TopAppBarScrollBehavior,
    screen: String
) {

    LargeTopAppBar (
        title = {
            Text(screen)
        },

        // Expand upon scroll
        scrollBehavior = scrollBehavior
    )
}