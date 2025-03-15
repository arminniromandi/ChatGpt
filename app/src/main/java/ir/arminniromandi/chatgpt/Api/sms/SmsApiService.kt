package ir.arminniromandi.myapplication

import ir.arminniromandi.myapplication.response.response
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


interface SmsApiService {
    @Headers(
        "Content-Type: application/json",
        "x-api-key: Nh2F5r8zs2SdtrJql4FWm1fj9XluVzScqmBwOXKhZgdYXCt4"
    )
    @POST("send/verify")
    fun sendRequest(
        @Body requestSmsBody: RequestSmsBody): Call<response>
}