package ir.arminniromandi.chatgpt.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import ir.arminniromandi.chatgpt.AppTheme
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.background2

class PromptLibraryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {

                Scaffold(
                    modifier = Modifier.background(background2),
                    topBar = {
                        Row(
                            Modifier.fillMaxWidth()
                        ) {
                            FloatingActionButton(
                                {}
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.search_normal),
                                    contentDescription = "searchBtn",
                                    tint = Color.Black
                                )
                            }

                        }
                    }

                ) {
                    Text("hello", modifier = Modifier.padding(it))
                }

            }
        }
    }

}