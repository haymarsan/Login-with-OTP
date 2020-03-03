package com.haymarsan.loginwithotp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.haymarsan.loginwithotp.data.vos.OauthVO
import com.haymarsan.loginwithotp.data.vos.SMSVO
import com.haymarsan.loginwithotp.data.vos.SmsBodyVO
import com.haymarsan.loginwithotp.repository.RepositoryImpl

class ViewModelImpl(application: Application): AndroidViewModel(application),ViewModel {

    private val repository = RepositoryImpl()
    override fun getOauthKeyFromRepo(
        userName: String,
        password: String,
        grantType: String
    ): LiveData<OauthVO> {

       return repository.getOauthToken(userName, password, grantType)
    }

    override fun getSMSFromRepo(authKey: String, smsBodyVO: SmsBodyVO): LiveData<SMSVO> {
        return repository.getSMS(authKey, smsBodyVO)
    }
}