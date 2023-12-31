package com.accidentaldeveloper.heart.helper

import android.content.Context
import com.accidentaldeveloper.heart.helper.AppConstant.PREF_TOKEN_FILE
import com.accidentaldeveloper.heart.helper.AppConstant.USER_TOKEN
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TokenManager @Inject constructor(@ApplicationContext context: Context) {
    private var prefs = context.getSharedPreferences(PREF_TOKEN_FILE,Context.MODE_PRIVATE)

    fun saveToken(token:String){
        val editor = prefs.edit()
        editor.putString(USER_TOKEN,token)
        editor.apply()
    }

    fun getToken(): String? {
        return prefs.getString(USER_TOKEN,null)
    }
}