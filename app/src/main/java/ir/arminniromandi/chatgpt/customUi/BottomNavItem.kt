package ir.arminniromandi.chatgpt.customUi

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ir.arminniromandi.chatgpt.Fragment.home.BottomNavItems
import ir.arminniromandi.chatgpt.R

@Composable
fun RowScope.BottomNavItem(
    currentRoute: String?,
    item: BottomNavItems,
    navController: NavHostController
) {
    NavigationBarItem(
        selected = currentRoute == item.name,


        colors = NavigationBarItemDefaults.colors(

        ),
        onClick = {
            navController.navigate(item.name) {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            }
        },
        icon = {

            Icon(
                imageVector = item.icon,
                contentDescription = item.name,
                tint = if (currentRoute == item.name) Color.White else Color.LightGray
            )

        },
        label = {
            Text(
                text = item.name,
                modifier = Modifier.padding(top = 8.dp),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.satoshi_regular))
                )
            )
        }
    )
}