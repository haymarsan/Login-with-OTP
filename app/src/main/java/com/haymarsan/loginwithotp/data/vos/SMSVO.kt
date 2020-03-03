package com.haymarsan.loginwithotp.data.vos

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SMSVO (
    @SerializedName("TrxnRefNum") val TrxnRefNum: String,
    @SerializedName("Response") val Response: ArrayList<ResponseVO>
): Serializable