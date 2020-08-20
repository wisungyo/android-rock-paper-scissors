package com.binar.ccgameandprofile.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.binar.ccgameandprofile.R
import com.binar.ccgameandprofile.database.Memo
import com.binar.ccgameandprofile.database.MemoDatabase
import kotlinx.android.synthetic.main.activity_add_memo.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class AddMemo : AppCompatActivity() {
    private lateinit var db: MemoDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_memo)
        this.supportActionBar?.hide()

        MemoDatabase.getIntance(this)?.let {
            db = it
        }

        btn_add.setOnClickListener {
            if (et_add_tanggal.text.isEmpty() || et_add_isi.text.isEmpty()) {
                Toast.makeText(this, "Tanggal dan Isi Memo tidak boleh kosong", Toast.LENGTH_LONG).show()
            } else {
                val item = Memo(null, et_add_tanggal.text.toString(), et_add_isi.text.toString())
                GlobalScope.launch {
                    val totalSaved = db.memoDao().insertMemo(item)
                    runOnUiThread {
                        if (totalSaved <= 0) {
                            Toast.makeText(
                                this@AddMemo,
                                "Data gagal disimpan",
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            Toast.makeText(
                                this@AddMemo,
                                "Data berhasil disimpan",
                                Toast.LENGTH_LONG
                            ).show()
                            Log.d("ADD", "ADDING ${et_add_tanggal.text.toString()} & ${et_add_isi.text.toString()}")
                            Log.d("ADD", "ADDED ${et_add_tanggal.text.toString()} & ${et_add_isi.text.toString()}")
                        }
                    }
                }
                finish()
            }
        }
    }
}