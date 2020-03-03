package com.haymarsan.loginwithotp.data.vos

data class SmsBodyVO (
    val telCode:String,
    val subscriberNum:String,
    val message:String,
    val trxnRefNum:String,
    val clientCode:String
)