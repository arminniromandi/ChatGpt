package ir.arminniromandi.chatgpt.Fragment.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.background2
import ir.arminniromandi.chatgpt.gray_300
import ir.arminniromandi.chatgpt.viewmodel.MainViewModel
import ir.arminniromandi.chatgpt.white
import ir.arminniromandi.myapplication.Tool.Constance.FloatingActionButtonModifier


@Composable
fun History(navController: NavController, viewModel: MainViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .background(background2),

        ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {


            Text(
                text = "Chat History",
                color = white,
                fontFamily = FontFamily(Font(R.font.satoshi_medium)),
                fontSize = 24.sp
            )


            FloatingActionButton({

            }) {

                Icon(
                    painter = painterResource(R.drawable.search_normal),
                    contentDescription = "Search",
                    modifier = FloatingActionButtonModifier
                )
            }


        }

        HorizontalDivider(modifier = Modifier.padding(horizontal = 8.dp))

        LazyColumn(){
            items(10){
                HistoryItem("Title","this is text and no meaning")
            }

        }


    }

}

@Composable
private fun HistoryItem(title: String, text: String) {


    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            title,
            color = white,
            fontFamily = FontFamily(Font(R.font.satoshi_medium)),
            fontSize = 16.sp
        )

        Text(
            title,
            color = gray_300,
            fontFamily = FontFamily(Font(R.font.satoshi_medium)),
            fontSize = 15.sp
        )

    }
}