package com.haymarsan.loginwithotp.repository

import androidx.lifecycle.MutableLiveData
import com.haymarsan.loginwithotp.data.vos.OauthVO
import com.haymarsan.loginwithotp.data.vos.ResponseVO
import com.haymarsan.loginwithotp.data.vos.SMSVO
import com.haymarsan.loginwithotp.data.vos.SmsBodyVO
import com.haymarsan.loginwithotp.network.LoginApi
import com.haymarsan.loginwithotp.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryImpl : Repository {

    val loginApi: LoginApi = RetrofitService().createService(LoginApi::class.java)

    override fun getOauthToken(
        username: String,
        password: String,
        grant_type: String
    ): MutableLiveData<OauthVO> {

        val authToken = MutableLiveData<OauthVO>()

        loginApi.getTokenNW(username, password, grant_type).enqueue(object : Callback<OauthVO> {

            override fun onFailure(call: Call<OauthVO>, t: Throwable) {
                authToken.value = null
                error(t.message.toString())
            }

            override fun onResponse(call: Call<OauthVO>, response: Response<OauthVO>) {
                authToken.value = response.body()
            }

        })
        return authToken
    }

    override fun getSMS(authKey: String, smsBodyVO: SmsBodyVO): MutableLiveData<SMSVO> {
        val responseSMS = MutableLiveData<SMSVO>()

        loginApi.getSMSNW(authKey, smsBodyVO).enqueue(object : Callback<SMSVO> {
            override fun onFailure(call: Call<SMSVO>, t: Throwable) {
                responseSMS.value = null
                error(t.localizedMessage)
            }

            override fun onResponse(call: Call<SMSVO>, response: Response<SMSVO>) {
                responseSMS.value = response.body()
            }

        })
        return responseSMS

    }
}