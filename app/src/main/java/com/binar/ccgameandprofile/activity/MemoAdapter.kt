package com.binar.ccgameandprofile.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.binar.ccgameandprofile.R
import com.binar.ccgameandprofile.database.Memo
import com.binar.ccgameandprofile.dialogfragment.DialogUpdate
import kotlinx.android.synthetic.main.rv_card.view.*

class MemoAdapter(val listMemo: List<Memo>): RecyclerView.Adapter<MemoAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

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
            val dialog = DialogUpdate()
            val bundle = Bundle()
            listMemo[position].id?.let { it1 -> bundle.putInt("id", it1) }
            bundle.putString("tanggal", listMemo[position].tanggal)
            bundle.putString("isi", listMemo[position].isiMemo)
            dialog.arguments = bundle
            val fm = (holder.itemView.context as Profile).supportFragmentManager.beginTransaction()
            dialog.show(fm, DialogUpdate.TAG)
        }
    }

}