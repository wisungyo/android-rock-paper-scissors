package com.binar.ccgameandprofile.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.binar.ccgameandprofile.R

class Splash : AppCompatActivity() {
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        this.supportActionBar?.hide()

        handler = Handler()
        handler.postDelayed({
            val intentIntro = Intent(this, Intro::class.java)
            startActivity(intentIntro)
            finish()
        }, 700)
    }
}