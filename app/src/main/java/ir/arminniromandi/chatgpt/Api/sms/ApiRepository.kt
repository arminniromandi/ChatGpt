package ir.arminniromandi.myapplication

import ir.arminniromandi.myapplication.response.response
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ApiRepository private constructor() {
    companion object {
        private var apiRepository: ApiRepository? = null

        val instants: ApiRepository
            get() {
                if (apiRepository == null) apiRepository = ApiRepository()
                return apiRepository!!
            }



    }
    fun sendText(parameter: RequestBody ){
        RetrofitBuilder.apiService.sendRequest(parameter).enqueue(
            object : Callback<response>{
                override fun onResponse(call: Call<response>, response: Response<response>) {
                    if (response.isSuccessful){
                        println("تمام")
                    }else {
                        println("error is ${response.errorBody()}")
                        println(response.code())

                    }


                }

                override fun onFailure(call: Call<response>, t: Throwable) {
                    println("خطااااا$t")
                }


            }


        )
    }

}