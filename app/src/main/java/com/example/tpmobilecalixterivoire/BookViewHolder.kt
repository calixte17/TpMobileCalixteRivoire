package com.example.tpmobilecalixterivoire;

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var name: TextView = itemView.findViewById(R.id.name)
    var auteur: TextView = itemView.findViewById(R.id.auteur)
    var image: ImageView = itemView.findViewById(R.id.image)
}
