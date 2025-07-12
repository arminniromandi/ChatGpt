package ir.arminniromandi.chatgpt.model

import androidx.compose.ui.graphics.vector.ImageVector

data class SettingSection(
    val title: String,
    val items: List<SettingItem>
)

data class SettingItem(
    val title: String,
    val icon: ImageVector,
    val onClick: () -> Unit = {}
)
