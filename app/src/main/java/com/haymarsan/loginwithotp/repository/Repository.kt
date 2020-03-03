package com.haymarsan.loginwithotp.repository

import androidx.lifecycle.MutableLiveData
import com.haymarsan.loginwithotp.data.vos.OauthVO
import com.haymarsan.loginwithotp.data.vos.SMSVO
import com.haymarsan.loginwithotp.data.vos.SmsBodyVO

interface Repository {

    fun getOauthToken(username: String, password: String, grant_type: String): MutableLiveData<OauthVO>

    fun getSMS(authKey: String, smsBodyVO: SmsBodyVO): MutableLiveData<SMSVO>

}