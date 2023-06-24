package cloud.ironveil.librereader.ui.components.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import cloud.ironveil.librereader.R
import cloud.ironveil.librereader.ui.components.common.NavBar
import cloud.ironveil.librereader.ui.components.common.TitleBar
import com.alorma.compose.settings.ui.SettingsMenuLink

// Main settings page

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsPage(
    navController: NavController,
    scrollBehaviour: TopAppBarScrollBehavior
) {

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehaviour.nestedScrollConnection),

        topBar = {
            TitleBar(
                scrollBehaviour,
                stringResource(R.string.bottom_bar_settings)
            )
        },

        bottomBar = {
            NavBar(navController,
                "settings"
            )
        }

    ) { contentPadding ->

        Box(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
        ) {

            Column(
                modifier = Modifier
                    .nestedScroll(scrollBehaviour.nestedScrollConnection)
                    .fillMaxSize(),

            ) {

                // About link
                SettingsMenuLink(
                    icon = {
                        Icon(
                            Icons.Outlined.Info,
                            contentDescription = stringResource(R.string.settings_about_title)
                        )
                    },
                    title = {
                        Text(
                            stringResource(R.string.settings_about_title)
                        )
                    },
                    onClick = {
                        navController.navigate("settings_about")
                    }
                )
            }
        }
    }
}