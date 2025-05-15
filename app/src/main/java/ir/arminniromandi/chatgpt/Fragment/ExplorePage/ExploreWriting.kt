package ir.arminniromandi.chatgpt.Fragment.ExplorePage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ir.arminniromandi.chatgpt.customUi.topBar.TopBarExplore


@Composable
fun ExploreWriting (){

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        TopBarExplore()




        Text(text = "Explore Writing")


    }



}

