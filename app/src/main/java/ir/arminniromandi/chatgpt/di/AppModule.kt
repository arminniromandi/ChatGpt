package ir.arminniromandi.chatgpt.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.arminniromandi.composeapplication.AndroidConectivityObserver
import ir.arminniromandi.composeapplication.ConectivityObserver
import ir.arminniromandi.myapplication.Api.ChatAi.ApiRepository
import ir.arminniromandi.myapplication.Api.ChatAi.ChatApiService
import ir.arminniromandi.myapplication.SmsApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val SMS_URL = "https://api.sms.ir/v1/"
    private const val CHAT_URL = "https://api.avalai.ir/"


    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class ProvideSmsApi
    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class ProvideChatApi


    @Singleton
    @Provides
    @ProvideSmsApi
    fun provideRetrofitSms(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(SMS_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    @ProvideChatApi
    fun provideRetrofitChat(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(CHAT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Singleton
    @Provides
    fun provideSmsService(@ProvideSmsApi retrofit: Retrofit): SmsApiService =
        retrofit.create(SmsApiService::class.java)

    @Singleton
    @Provides
    fun provideChatService(@ProvideChatApi retrofit: Retrofit): ChatApiService =
        retrofit.create(ChatApiService::class.java)

    @Provides
    @Singleton
    fun provideApiRepository(apiService: ChatApiService): ApiRepository {
        return ApiRepository(apiService)
    }

    @Provides
    fun provideConnectivityObserver(
        @ApplicationContext context: Context
    ): ConectivityObserver {
        return AndroidConectivityObserver(context)
    }


}


