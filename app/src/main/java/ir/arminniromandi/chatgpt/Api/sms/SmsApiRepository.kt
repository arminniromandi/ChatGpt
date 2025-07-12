package ir.arminniromandi.chatgpt.Api.sms

import ir.arminniromandi.chatgpt.Api.sms.model.RequestSmsBody
import ir.arminniromandi.myapplication.SmsApiService
import ir.arminniromandi.myapplication.response.SmsResponse
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SmsApiRepository @Inject constructor(
    private val apiService: SmsApiService
) {

    suspend fun sendOtpReq(body: RequestSmsBody): Response<SmsResponse> {

        return try {
            apiService.sendRequest(body)

        }catch (e : Exception){
            throw e
        }
    }


}