package com.infinitybiz.triviaapp.View.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.infinitybiz.triviaapp.Data.DataBaseHandler
import com.infinitybiz.triviaapp.R
import com.infinitybiz.triviaapp.View.adapter.HistoryAdapter

class HistoryActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: HistoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val db = DataBaseHandler(this)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        var details = db.readData()
        adapter = HistoryAdapter(this, details)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}