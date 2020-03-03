package com.haymarsan.loginwithotp.network

import com.haymarsan.loginwithotp.data.vos.OauthVO
import com.haymarsan.loginwithotp.data.vos.SMSVO
import com.haymarsan.loginwithotp.data.vos.SmsBodyVO
import retrofit2.Call
import retrofit2.http.*

interface LoginApi {

    @FormUrlEncoded
    @POST("oauthserver/api/oauth/requesttoken")
    fun getTokenNW(

        @Field("password") password: String,
        @Field("username") username: String,
        @Field("grant_type") grant_type: String): Call<OauthVO>

    @POST("kbzapi/api/telco/sendsms")
    fun getSMSNW(
        @Header("Authorization") Authorization: String,
        @Body smsBodyVO: SmsBodyVO):Call<SMSVO>

}
