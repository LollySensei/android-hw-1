package com.example.android_hw_1

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter: RecyclerView.Adapter<MyViewHolder>() {
    private var items = ArrayList<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        Log.d("ADD", "onCreateViewHolder")
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItem() {
        items.add(itemCount + 1)
        notifyItemInserted(items.lastIndex)
    }

    fun setItems(items: ArrayList<Int>) {
        this.items = items
    }

    fun getItems(): ArrayList<Int> {
        return items
    }
}