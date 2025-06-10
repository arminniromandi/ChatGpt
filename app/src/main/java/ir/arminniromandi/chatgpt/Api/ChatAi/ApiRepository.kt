package ir.arminniromandi.myapplication.Api.ChatAi

import ir.arminniromandi.myapplication.Api.ChatAi.Model.ChatRequest
import ir.arminniromandi.myapplication.Api.ChatAi.Model.ChatResponse
import retrofit2.Response
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val apiService: ChatApiService
) {
    suspend fun getChatResponse(request: ChatRequest): Response<ChatResponse> {

        return try {
//            apiService.getChatResponse(request)
            var key = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySUQiOiI2ODQ2YzMxMDRiYTY4NmQzNWM4NjA0NTciLCJ0eXBlIjoiYXV0aCIsImlhdCI6MTc0OTQ2ODQzNH0.k2p-qfr-LFMquHntt4tRO0whAXDSJmoCGLuKmDmmMR8"
            apiService.getChatWithLiara(request ,key )
        } catch (e: Exception) {
            throw e
        }
    }

}