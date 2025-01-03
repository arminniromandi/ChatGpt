package ir.arminniromandi.myapplication

data class Parameter(
    val name: String,
    val value: String
)

data class RequestSmsBody(
    val mobile: String,
    val templateId: String,
    val parameters: List<Parameter>
)
