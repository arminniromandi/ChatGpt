package ir.arminniromandi.chatgpt.customUi

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.ui.theme.gradient
import ir.arminniromandi.chatgpt.ui.theme.gray_700
import ir.arminniromandi.chatgpt.ui.theme.gray_900
import ir.arminniromandi.chatgpt.ui.theme.white
import ir.arminniromandi.chatgpt.ui.theme.whiteGradient

@Composable
fun BoxIntro(modifier: Modifier , image : Int ,text:String ){

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
            .border(
                width = 1.dp,
                brush = Brush.verticalGradient(colorStops = gradient),
                shape = RoundedCornerShape(40.dp)
            )
            .clip(RoundedCornerShape(40.dp))

            .background(gray_700),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            Modifier
                .padding(horizontal = 8.dp, 10.dp)
                .drawBehind {
                    drawRoundRect(color = gray_900, cornerRadius = CornerRadius((32.dp).toPx()))
                }
                .border(
                    width = 1.dp,
                    brush = Brush.horizontalGradient(whiteGradient),
                    shape = RoundedCornerShape(32.dp)
                )

            ,
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "BrainImage",
                modifier
                    .padding(14.dp)
                    .size(52.dp)

            )
        }
        Text(
            text ,
            modifier.padding(horizontal = 10.dp),
            color = white,
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.satoshi_regular))

        )



    }




}

@Preview
@Composable
private fun IntroPreview() {

    BoxIntro(Modifier , R.drawable.brain , "Remembers what user said earlier in the conversation ")

}
