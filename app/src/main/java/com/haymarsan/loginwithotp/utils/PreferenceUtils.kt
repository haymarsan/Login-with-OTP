package com.haymarsan.loginwithotp.utils

import android.content.Context

class PreferenceUtils {

    companion object {
        fun saveData(context: Context, key: String, value: Any) {

            val preference = context.applicationContext.getSharedPreferences("TokenVO", Context.MODE_PRIVATE)
            val editor = preference.edit()
            editor.putString(key, "${value}")
            editor.apply()

        }


        fun loadData(context: Context, key: String): String? {

            val preference = context.applicationContext.getSharedPreferences("TokenVO", Context.MODE_PRIVATE)
            return preference.getString(key, "")

        }

    }

}