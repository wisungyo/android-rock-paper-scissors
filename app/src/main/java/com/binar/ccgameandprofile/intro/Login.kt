package com.binar.ccgameandprofile.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.binar.ccgameandprofile.R
import com.binar.ccgameandprofile.menu.Menu
import com.binar.ccgameandprofile.sharedpreference.SharedPreferences
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        this.supportActionBar?.hide()

        loginCheck()
        val preferences = SharedPreferences(this)

        et_email.setText("sabrina@binar.com")
        et_password.setText("binar123")

//        var showPassword = false
//        btn_eye_password.setOnClickListener {
//            if (showPassword == false) {
//                et_password.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
//                showPassword = true
//            } else if (showPassword == true) {
//                et_password.inputType = InputType.TYPE_CLASS_TEXT
//                showPassword = false
//            }
//        }

        btn_login.setOnClickListener {
            if (et_email.text.isEmpty() || et_password.text.isEmpty()) {
                Toast.makeText(this, "Email or Password cannot empty", Toast.LENGTH_LONG).show()
            } else if (et_email.text.toString() != preferences.getEmail() || et_password.text.toString() != preferences.getPassword()) {
                Toast.makeText(this, "Email or Password not match", Toast.LENGTH_LONG).show()
            } else {
                val intentLogin = Intent(this, Menu::class.java)
                startActivity(intentLogin)
                finish()
            }
        }

        btn_reset.setOnClickListener {
            preferences.setIsLogin(false)
            Toast.makeText(
                this,
                "Email dan Password berhasil direset",
                Toast.LENGTH_LONG
            ).show()
            loginCheck()
        }
    }

    fun loginCheck() {
        val preference = SharedPreferences(this)
        if (preference.getIsLogin()) {
            return
        } else {
            preference.setEmail("sabrina@binar.com")
            preference.setPassword("binar123")
            preference.setIsLogin(true)
        }
    }
}