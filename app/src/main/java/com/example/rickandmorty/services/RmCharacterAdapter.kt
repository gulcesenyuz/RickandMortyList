package com.example.rickandmorty.services

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.rickandmortyapp.R
import com.bumptech.glide.Glide
import com.example.rickandmorty.constants.OnItemClickListener
import com.example.rickandmorty.models.RmCharacter

class RmCharacterAdapter(
    private val rmList: List<RmCharacter>,
    private val listener: OnItemClickListener
    ) :
    RecyclerView.Adapter<RmCharacterAdapter.RmViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return RmViewHolder(view)
    }

    override fun onBindViewHolder(holder: RmViewHolder, position: Int) {
        holder.textViewName.text = rmList[position].name
        Glide.with(holder.itemView.context).load(rmList[position].image)
            .into(holder.imageViewAvatar)

    }

    override fun getItemCount(): Int {
        return rmList.size
    }

    inner class RmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener
    {
        val imageViewAvatar: ImageView = itemView.findViewById(R.id.imageViewAvatar)
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val id: String =rmList[adapterPosition].id.toString()

                listener.onItemClick(id)




        }
    }


    
}



