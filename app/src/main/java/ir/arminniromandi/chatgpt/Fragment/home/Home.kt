package ir.arminniromandi.chatgpt.Fragment.home

import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ir.arminniromandi.chatgpt.AppTheme
import ir.arminniromandi.chatgpt.Fragment.HomeScreens
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.black
import ir.arminniromandi.chatgpt.gradient
import ir.arminniromandi.chatgpt.gray_300
import ir.arminniromandi.chatgpt.gray_700
import ir.arminniromandi.chatgpt.white
import ir.arminniromandi.chatgpt.whiteGradient

@Composable
fun Home(navController: NavController) {
    val context = LocalContext.current

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())

            .padding(horizontal = 8.dp)
    ) {

        TopApp()

        Button(
            onClick = { navController.navigate(HomeScreens.ChatPage.screenName) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 8.dp),

            ) {
            Text(
                text = context.getString(R.string.new_chat),
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                fontFamily = FontFamily(Font(R.font.satoshi_medium)),
                fontSize = 20.sp
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            Explore()

            Prompt()
        }


    }
}


@Composable
private fun TopApp(context: Context = LocalContext.current) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            modifier = Modifier.size(48.dp),
            contentDescription = "logo"
        )
        Spacer(Modifier.width(8.dp))

        Text(
            text = context.getString(R.string.app_name),
            fontFamily = FontFamily(Font(R.font.satoshi_medium)),
            fontSize = 18.sp
        )
    }

    Spacer(Modifier.height(8.dp))
}


@Composable
private fun Explore() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "Explore More",
            fontSize = 28.sp,
            fontFamily = FontFamily(Font(R.font.satoshi_medium))
        )


        
        FloatingActionButton ({})  {
            Image(
                imageVector = Icons.Default.ArrowForward ,
                contentDescription = "Explore More"
            )
        }




    }

    val a = arrayOf(
        Items("job", Icons.Outlined.Email, "lorem ipsom a text that make perfect"),
        Items("job", Icons.Outlined.Email, "lorem ipsom a text that make perfect"),
        Items("job", Icons.Outlined.Email, "lorem ipsom a text that make perfect")
    )



    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(a) {
            ExpItems(it)
        }
    }


}

@Composable
private fun ExpItems(item: Items) {

    Column(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .width(210.dp)
            .wrapContentHeight()
            .clip(RoundedCornerShape(38.dp))
            .border(
                width = (1.5).dp,
                brush = Brush.verticalGradient(whiteGradient),
                shape = RoundedCornerShape(38.dp)
            )
            .background(gray_700)
            .padding(18.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            item.icon,
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

            fontSize = 28.sp,
            fontFamily = FontFamily(Font(R.font.satoshi_medium))
        )

        Image(
            painter = painterResource(R.drawable.more),
            modifier = Modifier.size(44.dp),
            contentDescription = "Explore More"
        )

    }

    val a = arrayOf("Seo", "Develope", "Marketing", "job", "Code")

    LazyHorizontalStaggeredGrid(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
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
            .padding(horizontal = 6.dp, vertical = 4.dp)
            .clip(RoundedCornerShape(28.dp))
            .background(Color.Black),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text,
            fontFamily = FontFamily(Font(R.font.satoshi_bold)),
            fontSize = 20.sp,
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 12.dp),
            color = white
        )

    }

}


private data class Items(
    val title: String,
    val icon: ImageVector,
    val des: String
)


@Preview(
    showSystemUi = true, showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,

)
@Composable
private fun HomePagePre() {
    AppTheme {
        Home(NavController(LocalContext.current))
    }
}



