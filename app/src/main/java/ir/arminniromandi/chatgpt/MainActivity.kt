package ir.arminniromandi.chatgpt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ir.arminniromandi.chatgpt.Fragment.home.Home
import ir.arminniromandi.chatgpt.Fragment.HomeScreens
import ir.arminniromandi.chatgpt.Fragment.home.BottomNavItems
import ir.arminniromandi.chatgpt.customUi.BottomNavItem
import ir.arminniromandi.chatgpt.viewmodel.MainViewModel




class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val item = arrayOf(
            BottomNavItems("Home" , Icons.Default.Home),
            BottomNavItems("Chat" , Icons.Default.Create)
        )

        setContent {
            AppTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                Scaffold(
                    bottomBar = {
                        NavigationBar(containerColor = Color(0xFF252525)) {
                            item.forEachIndexed { _, item ->
                                BottomNavItem(currentRoute, item, navController)
                                }
                            }



                    }
                ) { it ->

                    NavHost(
                        navController = navController,
                        startDestination = HomeScreens.Home.screenName,
                        enterTransition = {
                            slideInHorizontally(
                                initialOffsetX = { it },
                                animationSpec = tween(
                                    durationMillis = 600
                                ),
                            )
                        },

                        modifier = Modifier.padding(it)
                    ) {
                        composable(HomeScreens.Home.screenName) { Home(navController) }
                        composable(HomeScreens.ChatPage.screenName) {  }

                    }
                }





            }
        }
    }





}
