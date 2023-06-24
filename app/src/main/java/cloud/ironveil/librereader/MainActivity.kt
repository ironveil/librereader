package cloud.ironveil.librereader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cloud.ironveil.librereader.ui.components.common.NavBar
import cloud.ironveil.librereader.ui.components.common.TitleBar
import cloud.ironveil.librereader.ui.components.layout.BookPage
import cloud.ironveil.librereader.ui.components.layout.HomePage
import cloud.ironveil.librereader.ui.components.layout.SettingsPage
import cloud.ironveil.librereader.ui.components.layout.settings.SettingsAbout
import cloud.ironveil.librereader.ui.theme.LibrereaderTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {

            LibrereaderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val systemUiController = rememberSystemUiController()

                    SideEffect {
                        systemUiController.setSystemBarsColor(color = Color.Transparent)
                    }

                    val navController = rememberNavController()

                    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

                    NavHost(navController = navController, startDestination = "home") {
                        composable("home") { HomePage(navController, scrollBehavior) }
                        composable("books") { BookPage(scrollBehavior) }
                        composable("settings") { SettingsPage(navController, scrollBehavior) }

                        composable("settings_about") { SettingsAbout(navController, scrollBehavior) }
                    }
                }
            }
        }
    }
}