package ir.arminniromandi.chatgpt.Activity

import android.content.Intent
import android.os.Bundle
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
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.customUi.BottomNavItem
import ir.arminniromandi.chatgpt.model.ExploreCardItem
import ir.arminniromandi.chatgpt.navigation.navHosts.MainNavHost
import ir.arminniromandi.chatgpt.navigation.screens.ExploreScreens
import ir.arminniromandi.chatgpt.navigation.screens.MainScreens
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

        val items = listOf(
            ExploreCardItem(
                "Writing",
                R.drawable.pen_writing,
                "Writing a story or text for article or interview",
                ExploreScreens.Writing.screenName,
                {startActivity(Intent(this , MainActivity::class.java))}
            ),
            ExploreCardItem(
                "Gym Planner",
                R.drawable.pen_writing,
                "Create a personalized gym workout plan tailored.",
                ExploreScreens.GymPlanner.screenName,
                {startActivity(Intent(this , MainActivity::class.java))}
            )

        )


        setContent {
            val viewModel: MainViewModel = hiltViewModel()

            AppTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                val navEvent by viewModel.navEvent.collectAsState()


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
                        LaunchedEffect(currentRoute.toString() == MainScreens.ChatPage.screenName) {
                            delay(800)
                            visible.value =
                                currentRoute.toString() != MainScreens.ChatPage.screenName

                        }

                        AnimatedVisibility(
                            visible.value,
                            enter = fadeIn() + expandVertically(animationSpec = tween(500)),
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
                ) { innerPadding ->


                    MainNavHost(
                        navController,
                        innerPadding,
                        viewModel
                    )


                }


            }
        }
    }


}
