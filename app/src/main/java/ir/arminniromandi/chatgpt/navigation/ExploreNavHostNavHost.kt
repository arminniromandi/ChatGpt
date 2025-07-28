package ir.arminniromandi.chatgpt.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ir.arminniromandi.chatgpt.ui.explore.ExploreScreens
import ir.arminniromandi.chatgpt.ui.explore.exploreWriting.ExploreWriting
import ir.arminniromandi.chatgpt.ui.explore.homeExplore.ExploreScreen
import ir.arminniromandi.chatgpt.ui.main.MainScreens
import ir.arminniromandi.chatgpt.viewmodel.ExploreViewModel

@Composable
fun ExploreNavHost(
    navController : NavHostController,
    innerPadding : PaddingValues,
    viewModel: ExploreViewModel

) {

    NavHost(
        navController = navController,
        startDestination = MainScreens.Main.screenName,
        enterTransition = {
            fadeIn(
                animationSpec = tween(
                    durationMillis = 500
                )
            ) + slideInHorizontally(
                animationSpec = tween(
                    durationMillis = 500
                )
            )
        },
        exitTransition = {
            fadeOut(
                animationSpec = tween(500)
            ) + slideOutHorizontally(
                animationSpec = tween(
                    500
                )
            )
        },

        modifier = Modifier.padding(innerPadding)
    ) {
        composable(ExploreScreens.Writing.screenName) { ExploreWriting() }
        composable(ExploreScreens.Home.screenName) { ExploreScreen(viewModel) }

    }


}

