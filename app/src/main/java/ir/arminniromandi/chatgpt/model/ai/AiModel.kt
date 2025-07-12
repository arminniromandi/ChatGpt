package ir.arminniromandi.chatgpt.model.ai
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Recommend
import androidx.compose.ui.graphics.vector.ImageVector

enum class AiModel(val value:String , val icon : ImageVector ) {
    Gpt4Nano("gpt-4.1-nano" , Icons.Default.CheckCircle ),
    Gpt41Mini("gpt-4.1-mini" , Icons.Default.Recommend)
}