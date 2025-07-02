package ir.arminniromandi.chatgpt.Activity

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.arminniromandi.chatgpt.customUi.BottomNavItem
import ir.arminniromandi.chatgpt.ui.Setting.SettingScreen
import ir.arminniromandi.chatgpt.ui.main.History.HistoryScreen
import ir.arminniromandi.chatgpt.ui.main.MainScreens
import ir.arminniromandi.chatgpt.ui.main.chat.ChatScreen
import ir.arminniromandi.chatgpt.ui.main.home.HomeScreen
import ir.arminniromandi.chatgpt.ui.theme.AppTheme
import ir.arminniromandi.chatgpt.ui.theme.gradient
import ir.arminniromandi.chatgpt.viewmodel.MainViewModel
import ir.arminniromandi.myapplication.Tool.Constance.BottomNavHomeItems
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)




        setContent {
            val viewModel: MainViewModel = hiltViewModel()

            AppTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                val navEvent by viewModel.navEvent.collectAsState()

                Log.i("test" , currentRoute.toString())

                // اینجا به تغییرات navEvent گوش میدیم
                LaunchedEffect(navEvent) {
                    navEvent?.let {
                        navController.navigate(it)
                        viewModel.clearNavigation()
                    }
                }



                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF282828))
                        .drawWithCache {
                            val gradientB = Brush.linearGradient(
                                colorStops = gradient,
                                start = Offset(size.width, 0f),         // بالا راست
                                end = Offset(
                                    0f, size.height
                                )
                            )
                            onDrawBehind {
                                drawRect(brush = gradientB)
                            }
                        },
                    bottomBar = {
                        val visible = remember {
                            mutableStateOf(true)
                        }
                        LaunchedEffect(currentRoute.toString() ==MainScreens.ChatPage.screenName) {
                            delay(800)
                            visible.value = currentRoute.toString() != MainScreens.ChatPage.screenName

                        }


                        AnimatedVisibility(
                            visible.value,
                            enter = fadeIn()+ expandVertically(animationSpec = tween(500)),
                            exit = fadeOut() + shrinkVertically(animationSpec = tween(500)),
                        ) {

                            NavigationBar(
                                modifier = Modifier
                                    .navigationBarsPadding()
                                    .padding(start = 8.dp, end = 8.dp, bottom = 4.dp)
                                    .clip(RoundedCornerShape(60.dp)),
                                containerColor = Color(0xFF000000),
                                tonalElevation = 4.dp,
                            ) {
                                BottomNavHomeItems.forEachIndexed { _, item ->
                                    BottomNavItem(currentRoute, item, navController)
                                }
                            }

                        }

                        Spacer(modifier = Modifier.navigationBarsPadding())
                    }
                ) {innerPadding->


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
                            SettingScreen(context = this@MainActivity)

                        }
                        composable(MainScreens.History.screenName) {
                            HistoryScreen(viewModel)
                        }
                        composable(MainScreens.ChatPage.screenName) {
                            ChatScreen(
                                viewModel
                            )
                        }

                    }


                }


            }
        }
    }


}
