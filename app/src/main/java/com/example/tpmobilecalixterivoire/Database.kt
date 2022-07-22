package com.example.tpmobilecalixterivoire

import android.content.ContentValues
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

interface OnGetDataBase {
    fun getBook(book: List<Book>)
}

class Database {

    private val db = Firebase.firestore
    var listener: OnGetDataBase? = null

    private fun retrieveBooks(book: List<Book>) {
        listener?.getBook(book)
    }

    fun book(){
        db.collection("Livre")
            .get()
            .addOnSuccessListener { result ->
                retrieveBooks(result.documents.map { doc -> Book(
                    doc.id,
                    doc.data?.get("Nom"),
                    doc.data?.get("Auteur"),
                    doc.data?.get("Image"),
                ) })
            }
            .addOnFailureListener { exception ->
                Log.w(ContentValues.TAG, "Error getting documents.", exception)
            }
    }
}