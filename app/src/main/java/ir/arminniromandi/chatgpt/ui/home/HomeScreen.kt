package ir.arminniromandi.chatgpt.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.arminniromandi.chatgpt.Fragment.HomeScreens
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.Tool.util.makeShadow
import ir.arminniromandi.chatgpt.ui.home.component.ExploreSection
import ir.arminniromandi.chatgpt.ui.home.component.HistorySection
import ir.arminniromandi.chatgpt.ui.home.component.HomeHeader
import ir.arminniromandi.chatgpt.ui.home.component.PromptSection
import ir.arminniromandi.chatgpt.viewmodel.MainViewModel

@Composable
fun HomeScreen(viewModel: MainViewModel) {
    val context = LocalContext.current


    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 8.dp)
    ) {

        HomeHeader(
            context = context, onRoute = {
                viewModel.navigate(it)
            }
        )

        ElevatedButton(
            onClick = { viewModel.navigate(HomeScreens.ChatPage.screenName) },
            colors = ButtonDefaults.elevatedButtonColors(
                contentColor = Color.Black, containerColor = Color.White

            ),
            modifier = Modifier
                .fillMaxWidth()
                .makeShadow()
                .padding(horizontal = 10.dp, vertical = 8.dp),

            ) {
            Text(
                text = context.getString(R.string.new_chat),
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                fontFamily = FontFamily(Font(R.font.satoshi_medium)),
                fontSize = 20.sp
            )
        }



        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            Spacer(modifier = Modifier.height(8.dp))


            HistorySection(
                onRoute = {
                    viewModel.navigate(it)
                }
            )

            Spacer(modifier = Modifier.height(8.dp))


            ExploreSection(context)

            Spacer(modifier = Modifier.height(8.dp))


            PromptSection(context)
        }


    }


}