package ir.arminniromandi.myapplication.Api.ChatAi.Model


data class ChatRequest(
    val model: String ,
    val messages: List<Message>
)

data class Message(
    val role: String,
    val content: String
)

