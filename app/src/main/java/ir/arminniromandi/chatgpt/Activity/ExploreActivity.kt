package ir.arminniromandi.chatgpt.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.arminniromandi.chatgpt.AppTheme
import ir.arminniromandi.chatgpt.Fragment.ExploreScreens
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.gray_300
import ir.arminniromandi.chatgpt.gray_700
import ir.arminniromandi.chatgpt.model.ExploreCardItem
import ir.arminniromandi.chatgpt.white
import ir.arminniromandi.chatgpt.whiteGradient

class ExploreActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        val items = listOf(
            ExploreCardItem(
                "InterView",
                R.drawable.pen_writing,
                "lorem ipsom a text that make perfect",
                ExploreScreens.Writing.screenName
            ),
        )

        setContent {
            AppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(), topBar = { TopBar() }) { innerPadding ->

                    Column(
                        Modifier.padding(innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {

                        TopBar()
                        ExploreItems(items)


                    }

                }
            }
        }
    }


    @Composable
    private fun TopBar() {

        Box(
            Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .padding(horizontal = 14.dp),
        ) {

            FloatingActionButton(
                modifier = Modifier
                    .size(56.dp)
                    .padding(4.dp),

                onClick = {
                    startActivity(Intent(this@ExploreActivity, MainActivity::class.java))
                }, shape = CircleShape, containerColor = Color.White
            ) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "back")

            }

            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "Explore",
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.satoshi_medium)),
                fontSize = 24.sp
            )


        }

    }


    @Composable
    private fun ExploreItems(item: List<ExploreCardItem>) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            itemsIndexed(item) { _, Item ->

                ExploreCard(item = Item)


            }

        }


    }


    @Composable
    private fun ExploreCard(item: ExploreCardItem) {

        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .width(160.dp)
                .clip(RoundedCornerShape(32.dp))
                .border(
                    width = (1).dp,
                    brush = Brush.verticalGradient(whiteGradient),
                    shape = RoundedCornerShape(38.dp)
                )
                .background(gray_700)
                .padding(16.dp),
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


    @Preview
    @Composable
    private fun Pre() {
        ExploreCard(
            item = ExploreCardItem(
                "job", R.drawable.pen_writing, "lorem ipsom a text that make perfect"
            )
        )
    }

    @Preview
    @Composable
    private fun PreView() {


        val items = listOf(
            ExploreCardItem(
                "Writing", R.drawable.pen_writing, "lorem ipsom a text that make perfect"
            ),
        )

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TopBar()
            ExploreItems(items)
        }


    }


}

