package ir.arminniromandi.chatgpt.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.arminniromandi.composeapplication.AndroidConectivityObserver
import ir.arminniromandi.composeapplication.ConectivityObserver
import ir.arminniromandi.myapplication.SmsApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create() // Create the GsonConverterFactory
    }

    @Singleton
    @Provides
    fun provideRetrofitSms(gsonConverterFactory: GsonConverterFactory):Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.sms.ir/v1/") // آدرس پایه سرور خود را قرار دهید
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit): SmsApiService =
        retrofit.create(SmsApiService::class.java)

    @Provides
    @Singleton
    fun provideConnectivityObserver(
        @ApplicationContext context: Context
    ): ConectivityObserver {
        return AndroidConectivityObserver(context)
    }



}