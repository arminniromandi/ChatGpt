package ir.arminniromandi.chatgpt.Fragment.IntroFragment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.HorizontalDivider
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
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.black
import ir.arminniromandi.chatgpt.customUi.BoxIntro
import ir.arminniromandi.chatgpt.customUi.MText
import ir.arminniromandi.chatgpt.gradient
import ir.arminniromandi.chatgpt.white

@Composable
fun Intro(modifier: Modifier) {
    Column(
        modifier
            .background(brush = Brush.verticalGradient(gradient))
            .padding(8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        
        Column(
            Modifier.fillMaxWidth(),

            ) {


            Row(
                modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.logo),
                        modifier = Modifier.size(48.dp),
                        contentDescription = "logo"
                    )

                    Spacer(modifier.width(8.dp))
                    Text(
                        "Chat Gpt",
                        fontSize = 18.sp,
                        color = white,
                        fontFamily = FontFamily(Font(R.font.satoshi_bold))
                    )
                }
                Text(
                    "skip",
                    color = white,
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.satoshi_regular))
                )
            }
            
            HorizontalDivider(modifier.height(1.dp))
            MText("Explore", 64, R.font.satoshi_regular, white)
            MText("Infinite", 64, R.font.satoshi_regular, Color(0xFFA7BA88))
            MText("Of Writing.", 64, R.font.satoshi_regular, white)

        }
        Column{

            BoxIntro(
                Modifier,
                R.drawable.brain,
                "Remembers what user said earlier in the conversation "
            )
            BoxIntro(Modifier, R.drawable.edit, "Allows user to provide follow-up corrections ")
            BoxIntro(
                Modifier,
                R.drawable.brain,
                "Trained to decline inappropriate\n" + "requests "
            )


            Row(
                modifier
                    .fillMaxWidth()
                    .padding(12.dp, 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ElevatedButton(
                    onClick = {},
                    modifier = Modifier
                        .height(52.dp)
                ) {
                    Text(
                        text = "Verify",
                        color = black,
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.satoshi_medium))
                    )
                }
            }

        }

    }
}

@Preview
@Composable
private fun Prev() {
    Intro(Modifier)
}

