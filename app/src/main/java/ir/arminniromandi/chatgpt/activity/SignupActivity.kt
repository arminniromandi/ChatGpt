package ir.arminniromandi.chatgpt.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.arminniromandi.chatgpt.navigation.screens.IntroScreens
import ir.arminniromandi.chatgpt.ui.SignUp.IntroScreen
import ir.arminniromandi.chatgpt.ui.SignUp.LoginScreen
import ir.arminniromandi.chatgpt.ui.theme.AppTheme
import ir.arminniromandi.chatgpt.viewmodel.SignUpViewModel

@AndroidEntryPoint
class SignupActivity : ComponentActivity() {
    private val viewModel by viewModels<SignUpViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContent {
            AppTheme {


                val navController = rememberNavController()

                Scaffold(

                ) { it ->

                    NavHost(
                        navController = navController,
                        startDestination = IntroScreens.Intro.screenName,
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
                        composable(IntroScreens.Intro.screenName) { IntroScreen(Modifier) }
                        composable(IntroScreens.Login.screenName) { LoginScreen(Modifier  ,viewModel) }

                    }
                }




            }

            }
        }
    }

