package ir.arminniromandi.chatgpt.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.arminniromandi.chatgpt.navigation.navHosts.ExploreNavHost
import ir.arminniromandi.chatgpt.ui.theme.AppTheme
import ir.arminniromandi.chatgpt.viewmodel.ExploreViewModel

@AndroidEntryPoint
class ExploreActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


//        intent.getStringExtra()



        setContent {
            val viewModel: ExploreViewModel = hiltViewModel<ExploreViewModel>()
            val navController = rememberNavController()
            val nav = viewModel.navEvent.collectAsState()

            LaunchedEffect(nav) {
                nav.value?.let {
                    navController.navigate(it)
                    viewModel.onNavDone()
                }

            }


            AppTheme {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route


                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF282F32)),

                    ) {

                    ExploreNavHost(
                        navController= navController,
                        innerPadding = it,
                        viewModel = viewModel
                        )

                }
            }
        }
    }


}




