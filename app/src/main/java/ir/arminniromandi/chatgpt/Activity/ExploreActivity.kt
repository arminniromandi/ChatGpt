package ir.arminniromandi.chatgpt.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ir.arminniromandi.chatgpt.AppTheme
import ir.arminniromandi.chatgpt.Fragment.ExplorePage.ExploreWriting
import ir.arminniromandi.chatgpt.Fragment.ExplorePage.HomeExplore
import ir.arminniromandi.chatgpt.Fragment.ExploreScreens
import ir.arminniromandi.chatgpt.Fragment.HomeScreens
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.model.ExploreCardItem

class ExploreActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        val items = listOf(
            ExploreCardItem(
                "Writing",
                R.drawable.pen_writing,
                "Writing a story or text for article or interview",
                ExploreScreens.Writing.screenName
            ),
            ExploreCardItem(
                "Code Generation",
                R.drawable.pen_writing,
                "Create code quickly with any programming language",
                ExploreScreens.Code.screenName
            )

            )

        setContent {
            AppTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route


                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF282F32)),

                    ) {

                    NavHost(
                        navController = navController,
                        startDestination = HomeScreens.Home.screenName,
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

                        modifier = Modifier.padding(it)
                    ) {
                        composable(ExploreScreens.Writing.screenName) { ExploreWriting() }
                        composable(ExploreScreens.Home.screenName) {
                            HomeExplore(
                                items,
                                navController
                            )
                        }

                    }


                }
            }
        }
    }


}

