package com.binar.ccgameandprofile.dialogfragment

import android.app.DatePickerDialog
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
import java.util.*

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

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        et_dialog_add_tanggal.setOnClickListener {
            val dpd = DatePickerDialog(view.context, R.style.DialogTheme, DatePickerDialog.OnDateSetListener {
                    view, year, monthOfYear, dayOfMonth ->
                    val newMonth: String
                    if (monthOfYear == 0) newMonth = "Januari"
                    else if (monthOfYear == 1) newMonth = "Februari"
                    else if (monthOfYear == 2) newMonth = "Maret"
                    else if (monthOfYear == 3) newMonth = "April"
                    else if (monthOfYear == 4) newMonth = "Mei"
                    else if (monthOfYear == 5) newMonth = "Juni"
                    else if (monthOfYear == 6) newMonth = "Juli"
                    else if (monthOfYear == 7) newMonth = "Agustus"
                    else if (monthOfYear == 8) newMonth = "September"
                    else if (monthOfYear == 9) newMonth = "Oktober"
                    else if (monthOfYear == 10) newMonth = "November"
                    else if (monthOfYear == 11) newMonth = "Desember"
                    else newMonth = "Bulan"
                        et_dialog_add_tanggal.setText("$dayOfMonth $newMonth $year")
            }, year, month, day)
            dpd.show()
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