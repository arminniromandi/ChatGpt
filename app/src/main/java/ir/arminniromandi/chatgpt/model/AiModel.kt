package ir.arminniromandi.chatgpt.model
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.ui.graphics.vector.ImageVector

enum class AiModel(val value:String , val icon : ImageVector , val isLiara : Boolean) {
    Gpt35T("gpt-3.5-turbo" , Icons.Default.Email , false) ,
    Gpt4Nano("gpt-4.1-nano" , Icons.Default.CheckCircle , false),
    GeminiLiara("google/gemini-2.0-flash-001" , Icons.Default.Email , true)
}