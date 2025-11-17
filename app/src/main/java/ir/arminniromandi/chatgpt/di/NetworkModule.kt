package ir.arminniromandi.chatgpt.di

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.arminniromandi.myapplication.Api.ChatAi.ChatApiService
import ir.arminniromandi.myapplication.SmsApiService
import ir.arminniromandi.myapplication.Tool.Constance.CHAT_URL
import ir.arminniromandi.myapplication.Tool.Constance.SMS_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Qualifier()
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




}