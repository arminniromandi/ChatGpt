package ir.arminniromandi.chatgpt.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import ir.arminniromandi.chatgpt.ui.Setting.SettingScreen
import ir.arminniromandi.chatgpt.ui.theme.AppTheme
import ir.arminniromandi.chatgpt.ui.theme.background2
import ir.arminniromandi.chatgpt.viewmodel.SettingViewModel

@AndroidEntryPoint
class SettingActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val viewModel = hiltViewModel<SettingViewModel>()
            AppTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                        .background(background2)
                ) { innerPadding ->
                    SettingScreen(modifier = Modifier.padding(innerPadding) , this)
                }
            }
        }
    }
}


