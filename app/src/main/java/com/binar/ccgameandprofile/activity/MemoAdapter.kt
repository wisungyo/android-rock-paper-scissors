package com.binar.ccgameandprofile.activity

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.binar.ccgameandprofile.R
import com.binar.ccgameandprofile.database.Memo
import kotlinx.android.synthetic.main.rv_card.view.*

class MemoAdapter(val listMemo: List<Memo>): RecyclerView.Adapter<MemoAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_card, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listMemo.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_memo_tanggal.text = listMemo[position].tanggal
        holder.itemView.tv_memo_isi.text = listMemo[position].isiMemo

        holder.itemView.cv_memo_item.setOnClickListener {
            val intentUpdate = Intent(holder.itemView.context, UpdateMemo::class.java)
            intentUpdate.putExtra("memo", listMemo[position])
            holder.itemView.context.startActivity(intentUpdate)
            Toast.makeText(
                holder.itemView.context,
                "${listMemo[position]}",
                Toast.LENGTH_LONG
            ).show()
        }
    }

}