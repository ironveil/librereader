package cloud.ironveil.librereader.ui.components.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import cloud.ironveil.librereader.R
import cloud.ironveil.librereader.ui.components.common.NavBar
import cloud.ironveil.librereader.ui.components.common.TitleBar

// Main homepage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(
    navController: NavController,
    scrollBehaviour: TopAppBarScrollBehavior
) {

    // TODO: actual backend
    val noOfBooks = 0

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehaviour.nestedScrollConnection),

        topBar = {
            TitleBar(
                scrollBehaviour,
                stringResource(R.string.bottom_bar_home)
            )
        },
        
        bottomBar = {
            NavBar(
                navController,
                "home"
            )
        }

    ) { contentPadding ->
        
        Box(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
        ) {
            
            // Display message if there are no books
            if (noOfBooks == 0) {
                Box(
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Text(text = stringResource(R.string.books_none))
                }

                // Show books
            } else {
                LazyColumn(
                    modifier = Modifier
                        .nestedScroll(scrollBehaviour.nestedScrollConnection)
                        .fillMaxSize(),
                    contentPadding = PaddingValues(0.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                }
            }
        }
    }
}