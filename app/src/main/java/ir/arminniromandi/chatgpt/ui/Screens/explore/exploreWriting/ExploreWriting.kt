package ir.arminniromandi.chatgpt.ui.explore.exploreWriting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ir.arminniromandi.chatgpt.ui.explore.TopBarExplore
import ir.arminniromandi.chatgpt.ui.explore.exploreWriting.component.WritingBody


@Composable
fun ExploreWriting (){

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        TopBarExplore()
        WritingBody()



    }


}