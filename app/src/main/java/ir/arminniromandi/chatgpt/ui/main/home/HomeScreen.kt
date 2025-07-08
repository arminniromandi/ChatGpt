package ir.arminniromandi.chatgpt.ui.main.home

import android.content.Intent
import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ir.arminniromandi.chatgpt.Activity.ExploreActivity
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.Tool.util.makeShadow
import ir.arminniromandi.chatgpt.ui.main.MainScreens
import ir.arminniromandi.chatgpt.ui.main.home.component.ExploreSection
import ir.arminniromandi.chatgpt.ui.main.home.component.HomeHeader
import ir.arminniromandi.chatgpt.ui.main.home.component.HomeHistorySection
import ir.arminniromandi.chatgpt.ui.main.home.component.PromptSection
import ir.arminniromandi.chatgpt.ui.theme.Typography
import ir.arminniromandi.chatgpt.viewmodel.MainViewModel
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(viewModel: MainViewModel = hiltViewModel<MainViewModel>()) {
    val context = LocalContext.current
    val density = LocalDensity.current
    var visible = remember {
        mutableStateOf(false)
    }


    //3 times
    LaunchedEffect(Unit) {
        delay(200)
        visible.value = true
    }



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
            onClick = { viewModel.navigate(MainScreens.ChatPage.screenName) },
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
                style = Typography.labelMedium.copy(color = Black)
            )
        }



        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            Spacer(modifier = Modifier.height(8.dp))


            HomeHistorySection(
                onRoute = {
                    viewModel.navigate(it)
                },
                visible = visible.value,
                density = density
            )

            Spacer(modifier = Modifier.height(8.dp))



            Log.i("test" , visible.value.toString())
            ExploreSection(
                visible = visible,
                density = density,
                expClick = {
                context.startActivity(
                    Intent(
                        context,
                        ExploreActivity::class.java
                    )
                )
            })

            Spacer(modifier = Modifier.height(8.dp))




            PromptSection(
                context = context,
                visible = visible.value,
                density = density,
            )
        }


    }


}