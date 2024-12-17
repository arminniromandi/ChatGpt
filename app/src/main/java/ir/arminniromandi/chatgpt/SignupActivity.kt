package ir.arminniromandi.chatgpt

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import ir.arminniromandi.chatgpt.customUi.MText

class SignupActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var navController = rememberNavController()

            AppTheme {


            }
        }
    }
}


@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {


    Scaffold(

    ) {

        Column(
            modifier
                .background(
                    brush = Brush.verticalGradient(gradient)
                )
                .padding(it)
                .padding(8.dp)

                .fillMaxSize()
        ) {
            Row(
                modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(painter = painterResource(R.drawable.logo),
                        modifier = Modifier.size(48.dp),
                        contentDescription = "logo"
                    )

                    Spacer(modifier.width(8.dp))
                    Text("Chat Gpt" ,
                        fontSize = 18.sp ,
                        fontFamily = FontFamily(Font(R.font.satoshi_bold))
                    )
                }
                Text(
                    "skip",
                    fontSize = 18.sp,
                    fontFamily = FontFamily (Font(R.font.satoshi_regular))
                )
            }

            

            Column(
                Modifier.fillMaxWidth()

            ) {
                MText("Explore", 64, R.font.satoshi_regular, white)
                MText("Infinite", 64, R.font.satoshi_regular, Color(0xFFA7BA88))
                MText("Of Writing.", 64, R.font.satoshi_regular, white)

            }

            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // TODO: create box of that 
            }



        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,

)
@Composable
fun GreetingPreview2() {
    AppTheme {
        Greeting2("Android")
    }
}