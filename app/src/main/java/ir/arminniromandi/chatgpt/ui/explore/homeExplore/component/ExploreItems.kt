package ir.arminniromandi.chatgpt.ui.explore.homeExplore.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.model.ExploreCardItem
import ir.arminniromandi.chatgpt.navigation.screens.ExploreScreens
import ir.arminniromandi.chatgpt.ui.theme.gray_300
import ir.arminniromandi.chatgpt.ui.theme.gray_700
import ir.arminniromandi.chatgpt.ui.theme.white
import ir.arminniromandi.chatgpt.ui.theme.whiteGradient
import ir.arminniromandi.chatgpt.viewmodel.ExploreViewModel


@Composable
fun ExploreItems(item: List<ExploreCardItem> , viewModel: ExploreViewModel ) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(item) { index, item ->
            ExploreCard(item = item  , ExploreScreens.Writing.screenName , viewModel)

        }

    }
}


@Composable
private fun ExploreCard(item: ExploreCardItem ,route : String , viewModel: ExploreViewModel) {


    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .width(160.dp)
            .clip(RoundedCornerShape(38.dp))
            .border(
                width = (1).dp,
                brush = Brush.verticalGradient(whiteGradient),
                shape = RoundedCornerShape(38.dp)
            )
            .background(gray_700)
            .padding(16.dp)
            .clickable {
                viewModel.navigate(route)
            },
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(item.icon),
            modifier = Modifier.size(30.dp),
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