package ir.arminniromandi.chatgpt.customUi

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ir.arminniromandi.chatgpt.R
import ir.arminniromandi.chatgpt.model.BottomNavItems
import ir.arminniromandi.chatgpt.ui.theme.gray_700
import ir.arminniromandi.chatgpt.ui.theme.white
import kotlinx.coroutines.delay

@Composable
fun RowScope.BottomNavItem(
    currentRoute: String?,
    item: BottomNavItems,
    navController: NavHostController
) {


        NavigationBarItem(
            modifier = Modifier.padding(vertical = 4.dp),
            selected = currentRoute == item.name,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = white,
                selectedTextColor = white,
                indicatorColor = Color.Transparent,
                unselectedIconColor = gray_700,
                unselectedTextColor = gray_700
            ),
            onClick = {
                val route = item.route
                if (currentRoute != route) {
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }

            },
            icon = {
                Icon(
                    painter = painterResource(item.icon),
                    contentDescription = item.name,
                    modifier = Modifier.size(30.dp),
                    tint = if (currentRoute == item.route) Color.White else gray_700
                )

            },
            label = {
                Text(
                    text = item.name,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.satoshi_medium))
                    )
                )
            }
        )

}