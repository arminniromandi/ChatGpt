package ir.arminniromandi.chatgpt.ui.explore.gymplanner

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ir.arminniromandi.chatgpt.ui.explore.TopBarExplore
import ir.arminniromandi.chatgpt.ui.explore.gymplanner.componnent.GetInfo

@Composable
fun GymPlannerScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBarExplore()
        GetInfo()


    }


}