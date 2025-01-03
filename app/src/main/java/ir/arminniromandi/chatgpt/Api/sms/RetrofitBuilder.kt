package ir.arminniromandi.myapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitBuilder {


    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.sms.ir/v1/") // آدرس پایه سرور خود را قرار دهید
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val smsApiService = retrofit.create(SmsApiService::class.java)

}