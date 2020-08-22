package com.binar.ccgameandprofile.dialogfragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.binar.ccgameandprofile.R
import com.binar.ccgameandprofile.activity.Profile
import com.binar.ccgameandprofile.database.Memo
import com.binar.ccgameandprofile.database.MemoDatabase
import kotlinx.android.synthetic.main.dialog_add.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DialogAdd: DialogFragment() {
    companion object {
        const val TAG = "DialogAdd"
    }

    private lateinit var db: MemoDatabase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MemoDatabase.getIntance(view.context)?.let {
            db = it
        }
        btn_dialog_add_add.setOnClickListener {
            setupClickListeners()
        }
        btn_dialog_add_cancel.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    private fun setupClickListeners() {
        if (et_dialog_add_tanggal.text.isEmpty() || et_dialog_add_isi.text.isEmpty()) {
            Toast.makeText(context, "Tanggal dan Isi Memo tidak boleh kosong", Toast.LENGTH_LONG).show()
        } else {
            val item = Memo(
                null,
                et_dialog_add_tanggal.text.toString(),
                et_dialog_add_isi.text.toString()
            )
            GlobalScope.launch {
                val totalSaved = db.memoDao().insertMemo(item)
                (activity as Profile).runOnUiThread {
                    if (totalSaved <= 0) {
                        Toast.makeText(
                            context,
                            "Data gagal disimpan",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        Toast.makeText(
                            context,
                            "Data berhasil disimpan",
                            Toast.LENGTH_LONG
                        ).show()
                        Log.d(
                            "ADD",
                            "ADDING ${et_dialog_add_tanggal.text.toString()} & ${et_dialog_add_isi.text.toString()}"
                        )
                        Log.d(
                            "ADD",
                            "ADDED ${et_dialog_add_tanggal.text.toString()} & ${et_dialog_add_isi.text.toString()}"
                        )
                    }
                }
            }
            (activity as Profile).fetchData()
            dismiss()
        }
    }
}