package com.binar.ccgameandprofile.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.binar.ccgameandprofile.R
import com.binar.ccgameandprofile.database.MemoDatabase
import com.binar.ccgameandprofile.dialogfragment.DialogAdd
import com.binar.ccgameandprofile.sharedpreference.SharedPreferences
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Profile : AppCompatActivity() {
    private lateinit var db: MemoDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        this.supportActionBar?.hide()

        MemoDatabase.getIntance(this)?.let {
            db = it
        }

        iv_back.setOnClickListener {
            finish()
        }

        val preferences = SharedPreferences(this)
        et_profile_email.setText(preferences.getEmail())
        et_profile_password.setText(preferences.getPassword())

        fab_profile_add.setOnClickListener {
            DialogAdd().show(supportFragmentManager, DialogAdd.TAG)
        }

        et_profile_email.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                preferences.setEmail(et_profile_email.text.toString())
                Toast.makeText(
                    this@Profile,
                    "Email berhasil diganti",
                    Toast.LENGTH_LONG
                ).show()
            }
        })

        et_profile_password.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                preferences.setPassword(et_profile_password.text.toString())
                Toast.makeText(
                    this@Profile,
                    "Password berhasil diganti",
                    Toast.LENGTH_LONG
                ).show()
            }

        })
    }

    override fun onResume() {
        super.onResume()
        fetchData()
    }

    fun fetchData() {
        GlobalScope.launch {
            val listMemo = db.memoDao().getAllMemo()
            runOnUiThread {
                val adapter = MemoAdapter(listMemo)
                rv_profile.layoutManager = LinearLayoutManager(this@Profile, LinearLayoutManager.VERTICAL, false)
                rv_profile.adapter = adapter
            }
        }
    }
}