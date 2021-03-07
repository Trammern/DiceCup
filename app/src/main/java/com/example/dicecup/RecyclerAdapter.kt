package com.example.dicecup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dicecupcompulsory.R
import kotlinx.android.synthetic.main.history_item.*
import kotlinx.android.synthetic.main.history_item.view.*

class RecyclerAdapter(private val exampleList: MutableList<Int>) : RecyclerView.Adapter<RecyclerAdapter.HistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
    val itemView = LayoutInflater.from(parent.context).inflate(
        R.layout.history_item,
    parent, false)

        return HistoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val currentItem = exampleList[position]
        holder.textView.text = currentItem.toString()
    }

    override fun getItemCount() = exampleList.size

    class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val textView: TextView = itemView.tvHistory
    }
}