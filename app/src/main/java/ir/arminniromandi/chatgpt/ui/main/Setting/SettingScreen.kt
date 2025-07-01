package ir.arminniromandi.chatgpt.ui.main.Setting

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.ui.theme.AppTheme
import ir.arminniromandi.chatgpt.ui.theme.Typography
import ir.arminniromandi.chatgpt.ui.theme.background2
import ir.arminniromandi.chatgpt.ui.theme.white
import ir.arminniromandi.myapplication.Tool.Constance.FloatingActionButtonModifier
import ir.arminniromandi.myapplication.Tool.Constance.SettingIconSize

@Composable
fun SettingScreen() {

    Column(
        Modifier
            .fillMaxSize()
            //todo: delete after
            .background(background2),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .fillMaxWidth()

                .padding(horizontal = 14.dp, vertical = 12.dp),
            contentAlignment = Alignment.CenterEnd
        ) {

            Text(
                text = "Explore",
                modifier = Modifier.align(Alignment.Center),
                color = Color.White,
                style = Typography().headlineSmall
            )

            FloatingActionButton(
                { },
                containerColor = Color.White,
                modifier = Modifier
                    .size(52.dp),
                shape = CircleShape
            ) {
                Image(
                    imageVector = Icons.AutoMirrored.Default.ArrowForward,
                    modifier = FloatingActionButtonModifier,
                    contentDescription = "Explore More"
                )
            }

        }


        val scrollState = rememberScrollState()

        Column(
            Modifier
                .fillMaxSize()
                .scrollable(scrollState , Orientation.Vertical)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                "Account",
                style = Typography.headlineLarge
            )
            Spacer(Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(R.drawable.user),
                    tint = white,
                    modifier = Modifier.size(SettingIconSize),
                    contentDescription = null

                )
                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    "Manage profile",
                    style = Typography.headlineMedium
                )
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 14.dp))


            Text(
                "Account",
                style = Typography.headlineLarge
            )
            Spacer(Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(R.drawable.user),
                    tint = white,
                    modifier = Modifier.size(SettingIconSize),
                    contentDescription = null

                )
                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    "Manage profile",
                    style = Typography.headlineMedium
                )
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 14.dp))

            Text(
                "Account",
                style = Typography.headlineLarge
            )
            Spacer(Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(R.drawable.user),
                    tint = white,
                    modifier = Modifier.size(SettingIconSize),
                    contentDescription = null

                )
                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    "Manage profile",
                    style = Typography.headlineMedium
                )
            }




        }


    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SettingPage() {
    AppTheme() {
        SettingScreen()
    }
}