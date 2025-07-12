package ir.arminniromandi.chatgpt.Api.sms.model

data class Parameter(
    val name: String,
    val value: String
)

data class RequestSmsBody(
    val mobile: String,
    val templateId: String = "687263",
    val parameters: List<Parameter>
)
