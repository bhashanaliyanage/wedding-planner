package com.example.weddingplanner.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weddingplanner.R
import com.example.weddingplanner.entities.Items
import kotlinx.android.synthetic.main.item_rv.view.*

class ItemsAdapter(private val arrList: List<Items>) :
    RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        return ItemsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.itemView.tvTitle.text = arrList[position].title
        holder.itemView.tvAmount.text = "LKR " + arrList[position].price
    }

    override fun getItemCount(): Int {
        return arrList.size
    }

    class ItemsViewHolder(view: View) : RecyclerView.ViewHolder(view)
}