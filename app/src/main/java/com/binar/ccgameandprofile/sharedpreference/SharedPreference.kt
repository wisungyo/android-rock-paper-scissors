package com.binar.ccgameandprofile.sharedpreference

import android.content.Context
import android.content.SharedPreferences

class SharedPreferences (context: Context) {
    private val SP_NAME: String = "login_data"
    private val SP_EMAIL: String = "sabrina@binar.com"
    private val SP_PASSWORD: String = "binar123"
    private val SP_ISLOGIN: Boolean = false
    private val SP_P1: String = "player1"
    private val SP_P2: String = "player2"
    private val preferences: SharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)

    fun getEmail(): String {
        return preferences.getString(SP_EMAIL, "sabrina@binar.com").toString()
    }
    fun setEmail(email: String) {
        val editor = preferences.edit()
        editor.putString(SP_EMAIL, email)
        editor.apply()
    }

    fun getPassword(): String {
        return preferences.getString(SP_PASSWORD, "binar123").toString()
    }
    fun setPassword(password: String) {
        val editor = preferences.edit()
        editor.putString(SP_PASSWORD, password)
        editor.apply()
    }

    fun getIsLogin(): Boolean {
        return preferences.getBoolean(SP_ISLOGIN.toString(), false)
    }
    fun setIsLogin(isLogin: Boolean) {
        val editor = preferences.edit()
        editor.putBoolean(SP_ISLOGIN.toString(), isLogin)
        editor.apply()
    }

    fun getP1(): String {
        return preferences.getString(SP_P1, "").toString()
    }
    fun setP1(input: String) {
        val editor = preferences.edit()
        editor.putString(SP_P1, input)
        editor.apply()
    }

    fun getP2(): String {
        return preferences.getString(SP_P2, "").toString()
    }
    fun setP2(input: String) {
        val editor = preferences.edit()
        editor.putString(SP_P2, input)
        editor.apply()
    }
}