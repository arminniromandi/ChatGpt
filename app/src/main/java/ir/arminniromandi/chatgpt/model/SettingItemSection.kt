package ir.arminniromandi.chatgpt.model

import androidx.compose.ui.graphics.vector.ImageVector

// Data class to represent a setting item
data class SettingItem(
    val title: String,
    val icon: ImageVector,
    val onClick: () -> Unit = {}
)

// Data class to represent a setting section
data class SettingSection(
    val title: String,
    val items: List<SettingItem>
)
