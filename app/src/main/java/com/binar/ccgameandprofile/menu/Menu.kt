package com.binar.ccgameandprofile.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.binar.ccgameandprofile.R
import com.binar.ccgameandprofile.ingame.VsComputer
import com.binar.ccgameandprofile.ingame.VsSahabat
import com.binar.ccgameandprofile.profile.Profile
import kotlinx.android.synthetic.main.activity_menu.*

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        this.supportActionBar?.hide()

        btn_profile.setOnClickListener {
            val intentProfile = Intent(this, Profile::class.java)
            startActivity(intentProfile)
        }

        btn_vs_player.setOnClickListener {
            val intentVsSahabat = Intent(this, VsSahabat::class.java)
            startActivity(intentVsSahabat)
        }

        btn_vs_com.setOnClickListener {
            val intentVsPlayer = Intent(this, VsComputer::class.java)
            startActivity(intentVsPlayer)
        }

        btn_exit.setOnClickListener {
            finishAffinity()
        }
    }
}