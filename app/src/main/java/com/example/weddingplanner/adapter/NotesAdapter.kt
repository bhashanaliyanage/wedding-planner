package com.example.weddingplanner.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weddingplanner.R
import com.example.weddingplanner.entities.Notes
import kotlinx.android.synthetic.main.notes_rv.view.*

class NotesAdapter(private val arrList: List<Notes>) :
    RecyclerView.Adapter<NotesAdapter.ItemsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        return ItemsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.notes_rv, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.itemView.tvNoteTitle.text = arrList[position].title
        holder.itemView.tvNoteSubTitle.text = arrList[position].note
    }

    override fun getItemCount(): Int {
        return arrList.size
    }

    class ItemsViewHolder(view: View) : RecyclerView.ViewHolder(view)
}