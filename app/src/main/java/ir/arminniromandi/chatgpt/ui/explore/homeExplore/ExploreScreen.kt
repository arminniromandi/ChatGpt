package ir.arminniromandi.chatgpt.ui.explore.homeExplore

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ir.arminniromandi.chatgpt.ext.util.SampleData.items
import ir.arminniromandi.chatgpt.ui.explore.TopBarExplore
import ir.arminniromandi.chatgpt.ui.explore.homeExplore.component.ExploreItems
import ir.arminniromandi.chatgpt.viewmodel.MainViewModel

@Composable
fun ExploreScreen(viewModel: MainViewModel) {

    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {

        TopBarExplore()
        ExploreItems(items , viewModel)


    }


}