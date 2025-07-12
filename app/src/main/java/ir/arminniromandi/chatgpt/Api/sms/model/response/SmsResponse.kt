package ir.arminniromandi.myapplication.response

data class SmsResponse(
    val data: Data,
    val message: String,
    val status: Int
)