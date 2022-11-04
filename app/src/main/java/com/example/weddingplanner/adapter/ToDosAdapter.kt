package com.example.weddingplanner.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weddingplanner.R
import com.example.weddingplanner.entities.ToDos
import kotlinx.android.synthetic.main.todo_rv.view.*

class ToDosAdapter(private val arrList: List<ToDos>) :
    RecyclerView.Adapter<ToDosAdapter.ItemsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        return ItemsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.todo_rv, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.itemView.tvTodoTitle.text = arrList[position].title
    }

    override fun getItemCount(): Int {
        return arrList.size
    }

    class ItemsViewHolder(view: View) : RecyclerView.ViewHolder(view)
}