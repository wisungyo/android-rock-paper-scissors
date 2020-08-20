package com.binar.ccgameandprofile.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.binar.ccgameandprofile.R
import com.binar.ccgameandprofile.database.Memo
import com.binar.ccgameandprofile.database.MemoDatabase
import kotlinx.android.synthetic.main.activity_update_memo.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UpdateMemo : AppCompatActivity() {
    lateinit var db: MemoDatabase
    lateinit var memo: Memo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_memo)
        this.supportActionBar?.hide()

        MemoDatabase.getIntance(this)?.let {
            db = it
        }
        intent.getParcelableExtra<Memo>("memo")?.let {
            memo = it
        }

        et_update_tanggal.setText(memo.tanggal)
        et_update_isi.setText(memo.isiMemo)

        btn_update.setOnClickListener {
            memo.apply {
                tanggal = et_update_tanggal.text.toString()
                isiMemo = et_update_isi.text.toString()
            }

            GlobalScope.launch {
                val rowUpdated = db.memoDao().updateMemo(memo)
                runOnUiThread {
                    if (rowUpdated > 0) {
                        Toast.makeText(
                            this@UpdateMemo,
                            "Memo berhasil terupdate",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        Toast.makeText(
                            this@UpdateMemo,
                            "Memo gagal terupdate",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
                finish()
            }
        }

        btn_delete.setOnClickListener {
            GlobalScope.launch {
                val totalDeleted = db.memoDao().deleteMemo(memo)
                runOnUiThread {
                    if (totalDeleted > 0) {
                        Toast.makeText(
                            this@UpdateMemo,
                            "Memo berhasil terhapus",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        Toast.makeText(
                            this@UpdateMemo,
                            "Memo gagal terhapus",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
                finish()
            }
        }

        btn_cancel.setOnClickListener {
            finish()
        }
    }
}