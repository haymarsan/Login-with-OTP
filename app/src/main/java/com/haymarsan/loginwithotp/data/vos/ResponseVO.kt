package com.haymarsan.loginwithotp.data.vos

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponseVO(
    @SerializedName("ResponseCode") val ResponseCode: String,
    @SerializedName("ResponseDescription") val ResponseDescription: String
) : Serializable