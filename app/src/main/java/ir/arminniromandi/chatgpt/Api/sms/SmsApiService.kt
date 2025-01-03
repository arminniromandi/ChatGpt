package ir.arminniromandi.myapplication

import ir.arminniromandi.myapplication.response.response
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


interface SmsApiService {
    @Headers(
        "Content-Type: application/json",
        "x-api-key: i4BFKtFAilcmOfc9abfQx40jD4aKsOq7NLe6eu5hqoBdfegljEv10qFc0meaLdH8"
    )
    @POST("send/verify")
    fun sendRequest(

        @Body requestSmsBody: RequestSmsBody): Call<response>
}