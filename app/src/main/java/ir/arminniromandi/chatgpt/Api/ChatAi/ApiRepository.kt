package ir.arminniromandi.myapplication.Api.ChatAi

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ir.arminniromandi.myapplication.Api.ChatAi.Model.ChatRequest
import ir.arminniromandi.myapplication.Api.ChatAi.Model.ChatResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val apiService: ChatApiService
) {
    suspend fun getChatResponse(request: ChatRequest):Response<ChatResponse> {
        return try {
             apiService.getChatResponse(request)
        } catch (e: Exception) {
            throw e
        }
    }


}