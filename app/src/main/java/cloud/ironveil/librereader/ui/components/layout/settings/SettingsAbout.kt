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
                title = { Text(text = "About" )},

                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate("settings")
                    }) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                },

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

                val uriHandler = LocalUriHandler.current
                
                SettingsMenuLink(
                    icon = {
                           Icon(painterResource(R.drawable.github_icon), contentDescription = "GitHub")
                    },
                    title = {
                        Text(stringResource(R.string.settings_github_title)) 
                   },
                    onClick = { uriHandler.openUri("https://github.com/ironveil/librereader")}
                )

                SettingsMenuLink (
                    icon = {
                        Icon(Icons.Filled.Photo, contentDescription = "Icons8")
                    },
                    title = {
                        Text("Icons by Icons8")
                    },
                    onClick = { uriHandler.openUri("https://icons8.com") }
                )
            }
        }
    }
}