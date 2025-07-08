package ir.arminniromandi.chatgpt.ui.Setting

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.HelpOutline
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ColorLens
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.arminniromandi.chatgpt.Activity.MainActivity
import ir.arminniromandi.chatgpt.model.SettingItem
import ir.arminniromandi.chatgpt.model.SettingSection
import ir.arminniromandi.chatgpt.ui.theme.AppTheme
import ir.arminniromandi.chatgpt.ui.theme.background2
import ir.arminniromandi.chatgpt.ui.theme.white
import ir.arminniromandi.myapplication.Tool.Constance.FloatingActionButtonModifier
import ir.arminniromandi.myapplication.Tool.Constance.SettingIconSize


@Composable
fun SettingScreen(modifier: Modifier = Modifier , context: Context) {


    // Sample Data
    val settingSections = listOf(
        SettingSection(
            title = "Account",
            items = listOf(
                SettingItem("Manage Profile", Icons.Filled.AccountCircle), // Corrected usage
                SettingItem("Subscription", Icons.Filled.Payment),      // Corrected usage
                SettingItem("Notifications", Icons.Filled.Notifications) // Corrected usage
            )
        ),
        SettingSection(
            title = "Preferences",
            items = listOf(
                SettingItem("Appearance", Icons.Filled.ColorLens),       // Corrected usage
                SettingItem("Privacy & Security", Icons.Filled.Shield)  // Corrected usage
            )
        ),
        SettingSection(
            title = "About & Support",
            items = listOf(
                SettingItem("Help Center", Icons.AutoMirrored.Filled.HelpOutline), // Corrected usage
                SettingItem("Terms of Service", Icons.Filled.Info),                 // Corrected usage
                SettingItem("Logout", Icons.AutoMirrored.Filled.Logout)             // Corrected usage
            )
        )
    )

    Column(
        modifier= modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 12.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = "Settings",
                modifier = Modifier.align(Alignment.Center),
                color = Color.White,
                style = MaterialTheme.typography.headlineSmall
            )
            FloatingActionButton(
                onClick = { context.startActivity(Intent(context , MainActivity::class.java))},
                containerColor = Color.White,
                modifier = Modifier.size(52.dp),
                shape = CircleShape
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward, // Using ImageVector
                    modifier = FloatingActionButtonModifier,
                    contentDescription = "Explore More",
                    tint = background2
                )
            }
        }


        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
        ) {
            settingSections.forEach {  section ->
                // Section Title
                Text(
                    text = section.title,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),

                )

                // Items in Section
                section.items.forEach { item ->
                    SettingRow(icon = item.icon, title = item.title, onClick = item.onClick)

                }
                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 32.dp),
                    color = Color.Gray.copy(alpha = 0.5f)
                )
            }


        }
    }
}

@Composable
fun SettingRow(icon: ImageVector, title: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            tint = white,
            modifier = Modifier.size(SettingIconSize),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
        )
        Spacer(Modifier.weight(1f))
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward, // Using ImageVector
            tint = Color.LightGray,
            modifier = Modifier.size(20.dp),
            contentDescription = "Go to $title"
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SettingPagePreview() {
    AppTheme {
        val context = LocalContext.current
        SettingScreen(context = context)
    }
}