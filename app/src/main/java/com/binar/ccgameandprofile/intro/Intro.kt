package com.binar.ccgameandprofile.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.binar.ccgameandprofile.R
import com.binar.ccgameandprofile.fragmentintro.Fragment1
import com.binar.ccgameandprofile.fragmentintro.Fragment2
import com.binar.ccgameandprofile.fragmentintro.Fragment3
import kotlinx.android.synthetic.main.activity_intro.*

class Intro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        this.supportActionBar?.hide()

        if (savedInstanceState == null) {
            makeCurrentFragment(Fragment1())
            bottom_navigation.setItemSelected(R.id.item_1)
        }

        bottom_navigation.setOnItemSelectedListener() { id ->
            when(id) {
                R.id.item_1 -> {
                    makeCurrentFragment(Fragment1())
                    
                }
                R.id.item_2 -> makeCurrentFragment(Fragment2())
                R.id.item_3 -> makeCurrentFragment(Fragment3())
            }
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.cl_fragment_content, fragment)
            commit()
        }

    fun callFragment2() {
        makeCurrentFragment(Fragment2())
        bottom_navigation.setItemSelected(R.id.item_2)
    }

    fun callFragment3() {
        makeCurrentFragment(Fragment3())
        bottom_navigation.setItemSelected(R.id.item_3)
    }

    fun callLoginPage() {
        val intentLoginPage = Intent(this, Login::class.java)
        startActivity(intentLoginPage)
        finish()
    }
}