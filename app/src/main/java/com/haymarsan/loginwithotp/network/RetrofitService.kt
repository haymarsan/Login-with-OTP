package com.haymarsan.loginwithotp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    val retrofit = Retrofit.Builder()
        .baseUrl("http://internal-api-ring-uat-lb-620610156.ap-southeast-1.elb.amazonaws.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun <S> createService(serviceClass: Class<S>):S{
        return retrofit.create(serviceClass)
    }





}