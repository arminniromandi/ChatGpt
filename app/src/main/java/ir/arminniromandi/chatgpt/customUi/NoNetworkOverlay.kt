package ir.arminniromandi.chatgpt.customUi

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import ir.arminniromandi.chatgpt.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoNetworkOverlay(
    show : Boolean,
    modifier: Modifier = Modifier
) {


    if (show) {
        BasicAlertDialog(
            onDismissRequest = { }
        ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                    ,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val composition by rememberLottieComposition(
                        spec = LottieCompositionSpec.RawRes(R.raw.anim)
                    )

                    LottieAnimation(
                        composition = composition,
                        iterations = Integer.MAX_VALUE,
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "No Internet!",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }

@Preview
@Composable
 fun dfr() {
    NoNetworkOverlay(true)
}

