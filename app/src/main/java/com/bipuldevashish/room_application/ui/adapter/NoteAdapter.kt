package com.bipuldevashish.room_application.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bipuldevashish.room_application.R
import com.bipuldevashish.room_application.room.NoteItem

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.MyViewHolder>() {

    private var noteList = emptyList<NoteItem>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = noteList[position]
        holder.itemView.findViewById<TextView>(R.id.note_title).text= currentItem.title
        holder.itemView.findViewById<TextView>(R.id.note_timestamp).text= currentItem.date.toString()
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    fun setData(note: List<NoteItem>){
        this.noteList = note
        notifyDataSetChanged()
    }
}