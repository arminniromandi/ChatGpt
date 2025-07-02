package ir.arminniromandi.chatgpt.model

import androidx.compose.runtime.Immutable

@Immutable
data class PromptItem(
    val title : String,
    val onClick: () -> Unit = {}

)
