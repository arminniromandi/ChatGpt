package ir.arminniromandi.chatgpt.ui.main.home.component

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ir.arminniromandi.chatgpt.Activity.SettingActivity
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.navigation.screens.MainScreens
import ir.arminniromandi.chatgpt.ui.theme.Typography
import ir.arminniromandi.chatgpt.ui.theme.white

@Composable
fun HomeHeader(
    context : Context,
    onRoute:(String) -> Unit
) {


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
                        onRoute(MainScreens.ChatPage.screenName)
                    },
                contentDescription = "logo"
            )
            Spacer(Modifier.width(8.dp))

            Text(
                text = context.getString(R.string.app_name),
                style = Typography.titleLarge,
                color = white
            )
        }

        IconButton({
            context.startActivity(Intent(context, SettingActivity::class.java))
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