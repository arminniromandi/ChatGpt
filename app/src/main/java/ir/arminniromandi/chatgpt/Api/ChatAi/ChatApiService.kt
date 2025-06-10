package ir.arminniromandi.myapplication.Api.ChatAi

import ir.arminniromandi.myapplication.Api.ChatAi.Model.ChatRequest
import ir.arminniromandi.myapplication.Api.ChatAi.Model.ChatResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST


interface ChatApiService {
    @Headers(
        "Content-Type: application/json",
        "Authorization: Bearer aa-erQd5i1Ryec0o9AOIJnWFPlkZScZwS0lyuVPsVvCzRklYLBA"
    )
    @POST("v1/chat/completions")
    suspend fun getChatResponse(@Body request: ChatRequest): Response<ChatResponse>


    @POST("chat/completions")
    suspend fun getChatWithLiara(
        @Body request: ChatRequest,
        @Header("Authorization") apiKey: String
    ): Response<ChatResponse>









}

