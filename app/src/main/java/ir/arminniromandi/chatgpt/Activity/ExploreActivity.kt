package ir.arminniromandi.chatgpt.Activity

import android.R.attr.name
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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.jeziellago.compose.markdowntext.MarkdownText
import ir.arminniromandi.chatgpt.AppTheme
import ir.arminniromandi.chatgpt.Fragment.ExplorePage.ExploreWriting
import ir.arminniromandi.chatgpt.Fragment.ExplorePage.HomeExplore
import ir.arminniromandi.chatgpt.ui.explore.ExploreScreens
import ir.arminniromandi.chatgpt.ui.main.MainScreens
import ir.arminniromandi.chatgpt.Tool.util.ExploreData.items

class ExploreActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()





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

                        modifier = Modifier.padding(it)
                    ) {
                        composable(ExploreScreens.Writing.screenName) { ExploreWriting() }
                        composable(ExploreScreens.Home.screenName) {
                            HomeExplore(
                                items, navController
                            )
                        }

                    }


                }
            }
        }
    }


}


@Preview(showSystemUi = true)
@Composable
private fun dnfd() {

    val text = """
        
       
        ---

        **کد تک خط:**

        `val x = 10`

        ---

        **بلوک کد چند خطی (کد Kotlin):**

        ```kotlin
        fun greet(name: String) {
            println("سلام، $name!")
        }

        greet("دنیا")
        ```
        
          | نام   | سن | شهر   |
        |-------|----|-------|
        | علی   | ۲۵ | تهران |
        | سارا  | ۳۰ | شیراز |
        | محمد  | ۲۸ | اصفهان |
        
    """.trimIndent()

    Column(Modifier.fillMaxSize()) {

        SelectionContainer(modifier = Modifier.wrapContentHeight()) {
            MarkdownText(
                text

            )


        }
    }


}

