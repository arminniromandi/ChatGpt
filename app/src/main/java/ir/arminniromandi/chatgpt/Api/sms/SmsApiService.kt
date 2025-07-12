package ir.arminniromandi.myapplication

import ir.arminniromandi.chatgpt.Api.sms.model.RequestSmsBody
import ir.arminniromandi.myapplication.response.SmsResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


interface SmsApiService {
    @Headers(
        "Content-Type: application/json",
        "x-api-key: Nh2F5r8zs2SdtrJql4FWm1fj9XluVzScqmBwOXKhZgdYXCt4"
    )
    @POST("send/verify")
    suspend fun sendRequest(
        @Body requestSmsBody: RequestSmsBody
    ): Response<SmsResponse>
}