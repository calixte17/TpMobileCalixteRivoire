package com.example.tpmobilecalixterivoire

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class BookAdapter : RecyclerView.Adapter<BookViewHolder>() {
    var mBook = listOf<Book>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BookViewHolder {

        val context = viewGroup.context
        val itemView = LayoutInflater.from(context).inflate(R.layout.books_list, viewGroup, false)
        return BookViewHolder(itemView)
    }

    override fun getItemCount(): Int = mBook.size

    override fun onBindViewHolder(bookViewHolder: BookViewHolder, position: Int) {
        val book = mBook[position]
        bookViewHolder.name.setText(book.name.toString())
        bookViewHolder.auteur.setText(book.auteur.toString())
        Picasso.get().load(book.image.toString()).into(bookViewHolder.image)
    }

}