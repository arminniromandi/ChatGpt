package ir.arminniromandi.chatgpt.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ir.arminniromandi.chatgpt.Fragment.HomeScreens
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.Typography
import ir.arminniromandi.chatgpt.black
import ir.arminniromandi.chatgpt.gray_300
import ir.arminniromandi.chatgpt.white
import ir.arminniromandi.myapplication.Tool.Constance.FloatingActionButtonModifier

@Composable
fun HistorySection(navController : NavHostController) {




    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 4.dp)
        ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "Chat History",
            style = Typography.headlineSmall,
            color = white
        )



        FloatingActionButton(
            { navController.navigate(HomeScreens.History.screenName)},
            containerColor = Color.White,
            modifier = Modifier.size(52.dp),
            shape = CircleShape
        ) {
            Image(
                imageVector = Icons.AutoMirrored.Default.ArrowForward,
                modifier = FloatingActionButtonModifier,
                contentDescription = "History"
            )
        }


    }




    Spacer(Modifier.height(2.dp))

    val itemsSample = remember { List(10) { "Sample" } }

    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {



        // TODO: make fix items
        items(itemsSample) {
            Row(
                modifier = Modifier
                    .padding(vertical = 2.dp , horizontal = 4.dp)
                    .clip(CircleShape)
                    .background(gray_300)
                    .padding(horizontal = 13.dp),

                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    "sample",
                    fontFamily = FontFamily(Font(R.font.satoshi_bold)),
                    fontSize = 18.sp,
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 12.dp),
                    color = black
                )

            }
        }
    }


}