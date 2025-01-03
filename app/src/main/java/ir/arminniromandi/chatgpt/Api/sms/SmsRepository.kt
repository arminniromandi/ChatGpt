package ir.arminniromandi.chatgpt.Api.sms

import ir.arminniromandi.myapplication.RequestSmsBody
import ir.arminniromandi.myapplication.SmsApiService
import javax.inject.Inject

class SmsRepository @Inject constructor(
    private val smsApiService: SmsApiService
) {
    suspend fun sendSms(request: RequestSmsBody) {
        smsApiService.sendRequest(request)
    }



}
