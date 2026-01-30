package ir.arminniromandi.chatgpt.navigation.navHosts

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ir.arminniromandi.chatgpt.navigation.screens.MainScreens
import ir.arminniromandi.chatgpt.ui.Screens.main.Setting.SettingScreen
import ir.arminniromandi.chatgpt.ui.explore.exploreWriting.ExploreWriting
import ir.arminniromandi.chatgpt.ui.explore.gymplanner.componnent.GetInfo
import ir.arminniromandi.chatgpt.ui.explore.homeExplore.ExploreScreen
import ir.arminniromandi.chatgpt.ui.main.History.HistoryScreen
import ir.arminniromandi.chatgpt.ui.main.chat.ChatScreen
import ir.arminniromandi.chatgpt.ui.main.home.HomeScreen
import ir.arminniromandi.chatgpt.viewmodel.ChatViewModel
import ir.arminniromandi.chatgpt.viewmodel.MainViewModel

@Composable
fun MainNavHost(
    navController: NavHostController,
    innerPadding: PaddingValues,
    viewModel: MainViewModel
) {
    NavHost(
        navController = navController,
        startDestination = MainScreens.Main.screenName,
        enterTransition = {
            slideInHorizontally(animationSpec = tween(500)) + fadeIn(
                animationSpec = tween(150)
            )
        },
        exitTransition = {
            slideOutHorizontally(
                animationSpec = tween(
                    500
                )
            ) + fadeOut(animationSpec = tween(150))
        },

        modifier = Modifier.padding(innerPadding)
    ) {
        composable(MainScreens.Main.screenName) {
            HomeScreen(viewModel)
        }

        composable(MainScreens.Setting.screenName) {
            val context = LocalContext.current
            SettingScreen(context = context)

        }

        composable(MainScreens.History.screenName) {
            HistoryScreen(viewModel)
        }

        composable(
            route = MainScreens.ChatPage.screenName,
            arguments = listOf(navArgument("chatId") { type = NavType.StringType })

        ) {
            val chatViewModel: ChatViewModel = hiltViewModel()
            val chatId = it.arguments?.getString("chatId")
            ChatScreen(
                chatViewModel,
                mainViewModel = viewModel,
                chatId ?:"-1"
            )
        }


        composable(MainScreens.ExploreWriting.screenName) { ExploreWriting() }
        composable(MainScreens.Explore.screenName) { ExploreScreen(viewModel) }
        composable (MainScreens.GymPlaner.screenName){ GetInfo() }



    }
}