package ir.arminniromandi.chatgpt.Fragment.home

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ir.arminniromandi.chatgpt.Activity.ExploreActivity
import ir.arminniromandi.chatgpt.Fragment.HomeScreens
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.Tool.util.ExploreData
import ir.arminniromandi.chatgpt.black
import ir.arminniromandi.chatgpt.gray_300
import ir.arminniromandi.chatgpt.gray_700
import ir.arminniromandi.chatgpt.model.ExploreCardItem
import ir.arminniromandi.chatgpt.white
import ir.arminniromandi.chatgpt.whiteGradient
import ir.arminniromandi.myapplication.Tool.Constance.FloatingActionButtonModifier

@Composable
fun Home(navController: NavHostController) {
    val context = LocalContext.current

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 8.dp)
    ) {

        TopApp(navController = navController)

        ElevatedButton(
            onClick = { navController.navigate(HomeScreens.ChatPage.screenName) },
            colors = ButtonDefaults.elevatedButtonColors(
                contentColor = Color.Black,
                containerColor = Color.White

            ),
            modifier = Modifier
                .fillMaxWidth()
                .makeShadow()
                .padding(horizontal = 10.dp, vertical = 8.dp),

            ) {
            Text(
                text = context.getString(R.string.new_chat),
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                fontFamily = FontFamily(Font(R.font.satoshi_medium)),
                fontSize = 20.sp
            )
        }



        Column(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            History(navController)

            Explore()

            Prompt()
        }


    }
}


@Composable
private fun TopApp(context: Context = LocalContext.current, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                modifier = Modifier
                    .size(48.dp)
                    .clickable {
                        navController.navigate(HomeScreens.ChatPage.screenName)
                    },
                contentDescription = "logo"
            )
            Spacer(Modifier.width(8.dp))

            Text(
                text = context.getString(R.string.app_name),
                fontFamily = FontFamily(Font(R.font.satoshi_medium)),
                fontSize = 18.sp
            )
        }

        IconButton({
            navController.navigate(HomeScreens.Setting.screenName)
        }) {
            Icon(
                painter = painterResource(R.drawable.profile_circle),
                contentDescription = "profile",
                tint = Color.White,
                modifier = Modifier.size(38.dp)
            )
        }
    }
    Spacer(Modifier.height(8.dp))
}


@Composable
private fun Explore() {

    val context = LocalContext.current


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "Explore More",
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.satoshi_medium))
        )



        FloatingActionButton(
            {
                context.startActivity(Intent(context, ExploreActivity::class.java))
            },
            containerColor = Color.White,
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
            ExpItems(it)
        }
    }


}

@Composable
private fun History(navController: NavController) {



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
            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.satoshi_medium))
        )



        FloatingActionButton(
            { navController.navigate(HomeScreens.History.screenName)},
            containerColor = Color.White,
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

    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {


        // TODO: make fix items
        items(10) {
            Row(
                modifier = Modifier
                    .padding(vertical = 2.dp)
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



@Composable
private fun ExpItems(item: ExploreCardItem) {

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

@Composable
private fun Prompt() {

    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "Prompt Library",

            fontSize = 24.sp,
            fontFamily = FontFamily(Font(R.font.satoshi_medium))
        )


        FloatingActionButton(
            {},
            elevation = FloatingActionButtonDefaults.elevation(10.dp),
            containerColor = Color.White,
            shape = CircleShape
        ) {
            Image(
                imageVector = Icons.AutoMirrored.Default.ArrowForward,
                modifier = FloatingActionButtonModifier,
                contentDescription = "Explore More"
            )
        }

    }

    val a = arrayOf("Seo", "Develope", "Marketing", "job", "Code")

    Spacer(Modifier.height(4.dp))

    LazyHorizontalStaggeredGrid(
        modifier = Modifier
            .fillMaxWidth()
            .height(125.dp),
        rows = StaggeredGridCells.Fixed(2),
        horizontalItemSpacing = 4.dp
    ) {
        items(a) {
            PromptItems(it)
        }
    }


}

@Composable
private fun PromptItems(text: String) {


    Row(
        modifier = Modifier
            .padding(vertical = 2.dp)
            .clip(CircleShape)
            .border(
                width = 1.dp,
                brush = Brush.horizontalGradient(whiteGradient),
                shape = CircleShape
            )
            .background(Color.Black)
            .padding(horizontal = 13.dp),

        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text,
            fontFamily = FontFamily(Font(R.font.satoshi_bold)),
            fontSize = 18.sp,
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 12.dp),
            color = white
        )

    }

}

@Composable
fun Modifier.makeShadow() =
    this.shadow(
        elevation = 15.dp,
        shape = ButtonDefaults.elevatedShape,
        ambientColor = Color.White,
        spotColor = Color.White,
        clip = true
    )

@Preview
@Composable
private fun deds() {
    Home(rememberNavController())
}




