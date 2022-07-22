package com.example.tpmobilecalixterivoire

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StartActivity : AppCompatActivity(), OnGetDataBase {
    private var myAdapter: BookAdapter = BookAdapter()
    private val db = Database()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        db.listener = this
        db.book()

        val listBook = findViewById<RecyclerView>(R.id.books_list)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        listBook.layoutManager = layoutManager
        listBook.adapter = myAdapter
    }

    override fun getBook(book: List<Book>) {
        myAdapter.mBook = book
        myAdapter.notifyDataSetChanged()
    }
}