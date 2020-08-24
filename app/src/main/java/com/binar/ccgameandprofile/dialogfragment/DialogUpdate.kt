package com.binar.ccgameandprofile.dialogfragment

import android.app.DatePickerDialog
import android.os.Bundle
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
import kotlinx.android.synthetic.main.dialog_update.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class DialogUpdate: DialogFragment() {
    companion object {
        const val TAG = "DialogUpdate"
    }

    private lateinit var db: MemoDatabase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_update, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MemoDatabase.getIntance(view.context)?.let {
            db = it
        }

        val bundle = arguments
        val id = bundle?.getInt("id", 0)
        val tanggal = bundle?.getString("tanggal", "").toString()
        val isiMemo = bundle?.getString("isi", "").toString()
        et_update_tanggal.setText(tanggal)
        et_update_isi.setText(isiMemo)

        btn_update_update.setOnClickListener {
            val newTanggal = et_update_tanggal.text.toString()
            val newIsi = et_update_isi.text.toString()
            GlobalScope.launch {
                val memoUpdated = db.memoDao().updateMemo(Memo(id, newTanggal, newIsi))
                (activity as Profile).runOnUiThread {
                   if (memoUpdated > 0) {
                       Toast.makeText(
                           view.context,
                           "Update berhasil",
                           Toast.LENGTH_LONG
                       ).show()
                   } else {
                       Toast.makeText(
                           view.context,
                           "Update gagal",
                           Toast.LENGTH_LONG
                       ).show()
                   }
                }
            }
            (activity as Profile).fetchData()
            dismiss()
        }
        btn_update_delete.setOnClickListener {
            GlobalScope.launch {
                val memoDeleted = db.memoDao().deleteMemo(Memo(id, tanggal, isiMemo))
                (activity as Profile).runOnUiThread {
                    if (memoDeleted > 0) {
                        Toast.makeText(
                            view.context,
                            "Delete berhasil",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        Toast.makeText(
                            view.context,
                            "Delete gagal",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
            (activity as Profile).fetchData()
            dismiss()
        }
        btn_update_cancel.setOnClickListener {
            dismiss()
        }

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        et_update_tanggal.setOnClickListener {
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
                et_update_tanggal.setText("$dayOfMonth $newMonth $year")
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
}