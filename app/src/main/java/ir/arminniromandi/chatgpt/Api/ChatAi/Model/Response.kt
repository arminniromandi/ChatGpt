package ir.arminniromandi.myapplication.Api.ChatAi.Model

// ChatResponse.kt
data class ChatResponse(
    val choices: List<Choice>
)

data class Choice(
    val message: Message
)

