package cloud.ironveil.librereader.ui.components.layout.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cloud.ironveil.librereader.R
import com.alorma.compose.settings.ui.SettingsMenuLink

// "About" page in settings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsAbout(
    navController: NavController,
    scrollBehaviour: TopAppBarScrollBehavior
) {
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehaviour.nestedScrollConnection),

        topBar = {
            MediumTopAppBar(
                title = {
                    Text(text = stringResource(R.string.settings_about_title) )
                },

                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate("settings")
                    }) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.navigation_back)
                        )
                    }
                },

                // Expand upon scroll
                scrollBehavior = scrollBehaviour
            )
        }

    ) { contentPadding ->
        Box(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
        ) {
            Column (
                modifier = Modifier
                    .nestedScroll(scrollBehaviour.nestedScrollConnection)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(0.dp)
            ) {

                // Allow external links
                val uriHandler = LocalUriHandler.current

                // GitHub repo link
                SettingsMenuLink(
                    icon = {
                           Icon(
                               painterResource(R.drawable.github_icon),
                               contentDescription = stringResource(R.string.settings_github_title)
                           )
                    },

                    title = {
                        Text(stringResource(R.string.settings_github_title)) 
                   },

                    onClick = { uriHandler.openUri("https://github.com/ironveil/librereader")}
                )

                // Icons8 link
                SettingsMenuLink (
                    icon = {
                        Icon(
                            Icons.Filled.Photo,
                            contentDescription = stringResource(R.string.settings_icons8_title)
                        )
                    },

                    title = {
                        Text(stringResource(R.string.settings_icons8_title))
                    },

                    onClick = { uriHandler.openUri("https://icons8.com") }
                )
            }
        }
    }
}