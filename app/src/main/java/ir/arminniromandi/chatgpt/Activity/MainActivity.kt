package ir.arminniromandi.chatgpt.Activity

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.arminniromandi.chatgpt.AppTheme
import ir.arminniromandi.chatgpt.Fragment.HomeScreens
import ir.arminniromandi.chatgpt.Fragment.home.BottomNavItems
import ir.arminniromandi.chatgpt.Fragment.home.ChatPage
import ir.arminniromandi.chatgpt.Fragment.home.Home
import ir.arminniromandi.chatgpt.customUi.BottomNavItem
import ir.arminniromandi.chatgpt.gradient
import ir.arminniromandi.chatgpt.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
     private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val item = arrayOf(
            BottomNavItems("Home" , Icons.Default.Home),
            BottomNavItems("ChatPage" , Icons.Default.Create)
        )
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)



        setContent {
            AppTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                Scaffold(
                    modifier = Modifier
                        .background(brush = Brush.verticalGradient(gradient)),
                    bottomBar = {
                        NavigationBar(
                            modifier = Modifier
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                                .clip(RoundedCornerShape(60.dp)),
                            containerColor = Color(0xFF000000),
                            tonalElevation = 4.dp,
                        ) {
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
                            fadeIn(
                                animationSpec = tween(
                                    durationMillis = 500
                                )
                            )
                        },
                        exitTransition ={
                            fadeOut(
                                animationSpec = tween(500)
                            )
                        }
                        ,

                        modifier = Modifier.padding(it)
                    ) {
                        composable(HomeScreens.Home.screenName) { Home(navController) }
                        composable(HomeScreens.ChatPage.screenName) { ChatPage(viewModel) }

                    }
                }





            }
        }
    }





}
