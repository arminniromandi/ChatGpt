package ir.arminniromandi.chatgpt.ui.main.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.Tool.util.ExploreData
import ir.arminniromandi.chatgpt.Typography
import ir.arminniromandi.chatgpt.gray_300
import ir.arminniromandi.chatgpt.gray_700
import ir.arminniromandi.chatgpt.model.ExploreCardItem
import ir.arminniromandi.chatgpt.white
import ir.arminniromandi.chatgpt.whiteGradient
import ir.arminniromandi.myapplication.Tool.Constance.FloatingActionButtonModifier

@Composable
fun ExploreSection(expClick:()-> Unit) {



    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "Explore More",
            color = white,
            style = Typography.headlineSmall)



        FloatingActionButton(
            { expClick },
            containerColor = Color.White,
            modifier = Modifier.size(52.dp),
            shape = CircleShape
        ) {
            Image(
                imageVector = Icons.AutoMirrored.Default.ArrowForward,
                modifier = FloatingActionButtonModifier,
                contentDescription = "Explore More"
            )
        }


    }




    Spacer(Modifier.height(2.dp))

    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {


        items(items = ExploreData.items) {
            ExploreItemCard(it)
        }
    }



}

@Composable
private fun ExploreItemCard(item: ExploreCardItem){

    Column(
        modifier = Modifier
            .padding(horizontal = 6.dp)
            .width(210.dp)
            .height(158.dp)
            .clip(RoundedCornerShape(38.dp))
            .border(
                width = (1.5).dp,
                brush = Brush.verticalGradient(whiteGradient),
                shape = RoundedCornerShape(38.dp)
            )
            .background(gray_700)
            .padding(12.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(item.icon),
            modifier = Modifier.size(28.dp),
            tint = white,
            contentDescription = ""
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = item.title,
            color = white,
            fontSize = 21.sp,
            fontFamily = FontFamily(Font(R.font.satoshi_medium))
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = item.des,
            color = gray_300,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.satoshi_medium))
        )

    }

}