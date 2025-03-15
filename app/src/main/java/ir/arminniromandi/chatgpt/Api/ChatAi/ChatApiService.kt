package ir.arminniromandi.myapplication.Api.ChatAi



import ir.arminniromandi.myapplication.Api.ChatAi.Model.ChatRequest
import ir.arminniromandi.myapplication.Api.ChatAi.Model.ChatResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ChatApiService {
    @Headers(
        "Content-Type: application/json",
        "Authorization: Bearer aa-erQd5i1Ryec0o9AOIJnWFPlkZScZwS0lyuVPsVvCzRklYLBA"
    )
    @POST("v1/chat/completions")
    suspend fun getChatResponse(@Body request: ChatRequest): Response<ChatResponse>
}

