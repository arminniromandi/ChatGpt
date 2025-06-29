package ir.arminniromandi.myapplication.Api.ChatAi

import ir.arminniromandi.myapplication.Api.ChatAi.Model.ChatRequest
import ir.arminniromandi.myapplication.Api.ChatAi.Model.ChatResponse
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiRepository @Inject constructor(
    private val apiService: ChatApiService
) {
    suspend fun getChatResponse(request: ChatRequest , isLiara : Boolean): Response<ChatResponse> {

        return try {
            var key = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySUQiOiI2ODQ2YzMxMDRiYTY4NmQzNWM4NjA0NTciLCJ0eXBlIjoiYXV0aCIsImlhdCI6MTc0OTQ2ODQzNH0.k2p-qfr-LFMquHntt4tRO0whAXDSJmoCGLuKmDmmMR8"

            if (isLiara)
                apiService.getChatWithLiara(request ,key )
            else
                apiService.getChatResponse(request)
        } catch (e: Exception) {
            throw e
        }
    }

}