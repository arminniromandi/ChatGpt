package ir.arminniromandi.chatgpt.ui.Screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
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
import ir.arminniromandi.chatgpt.ui.customUi.BottomNavItem
import ir.arminniromandi.chatgpt.navigation.navHosts.MainNavHost
import ir.arminniromandi.chatgpt.navigation.screens.MainScreens
import ir.arminniromandi.chatgpt.ui.theme.gradient
import ir.arminniromandi.chatgpt.viewmodel.MainViewModel
import ir.arminniromandi.myapplication.Tool.Constance.BottomNavHomeItems
import kotlinx.coroutines.delay

@Composable
fun MainScreen() {
    val viewModel: MainViewModel = hiltViewModel()


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
            .imePadding()
            .background(Color(0xFF282F32))
            /*.drawWithCache {
                val gradientB = Brush.linearGradient(
                    colorStops = gradient,
                    start = Offset(size.width, 0f),
                    end = Offset(
                        0f, size.height
                    )
                )
                onDrawBehind {
                    drawRect(brush = gradientB)
                }
            }*/,
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





