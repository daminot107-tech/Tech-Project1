package com.example.imdbclone.utils

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TokenManager @Inject constructor(@ApplicationContext context: Context) {
    private var sharedPreferences:SharedPreferences=context.getSharedPreferences("IDBMI_TOKEN",
        Context.MODE_PRIVATE)
    fun saveToken(token:String){
        val Editor:SharedPreferences.Editor=sharedPreferences.edit()
        Editor.putString("API_token",token)
        Editor.apply()
    }
   fun getToken():String?{
        return sharedPreferences.getString("API_TOKEN",null)

    }
}