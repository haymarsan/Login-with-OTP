package com.haymarsan.loginwithotp.viewmodel

import androidx.lifecycle.LiveData
import com.haymarsan.loginwithotp.data.vos.OauthVO
import com.haymarsan.loginwithotp.data.vos.SMSVO
import com.haymarsan.loginwithotp.data.vos.SmsBodyVO

interface ViewModel {

    fun getOauthKeyFromRepo(userName: String, password: String, grantType: String): LiveData<OauthVO>
    fun getSMSFromRepo(authKey: String, smsBodyVO: SmsBodyVO): LiveData<SMSVO>

}