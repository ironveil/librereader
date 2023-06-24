package cloud.ironveil.librereader.ui.components.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cloud.ironveil.librereader.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookPage(
    scrollBehaviour: TopAppBarScrollBehavior
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        modifier = Modifier.nestedScroll(scrollBehaviour.nestedScrollConnection).fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(50) {
            Image(painter = painterResource(R.drawable.generic_book_cover), contentDescription = "Book Cover")
        }
    }
}