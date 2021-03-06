package com.infinitybiz.triviaapp.View.Activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.infinitybiz.triviaapp.Data.DataBaseHandler
import com.infinitybiz.triviaapp.Model.User
import com.infinitybiz.triviaapp.R
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    lateinit var mName: TextView
    lateinit var mValue: TextView
    lateinit var mList: TextView
    lateinit var mFinish: Button
    lateinit var mHistory: Button
    var time: String? = null
    lateinit var name: String
    lateinit var value: String
    lateinit var stingList : String
    

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// get all values from Intent
        name = intent.getStringExtra("name").toString()
        value = intent.getStringExtra("value").toString()
         val getList = intent.getStringArrayListExtra("list")
        stingList= getList?.joinToString(" , ").toString()
        // Initialize the values
        mName = findViewById(R.id.name)
        mValue = findViewById(R.id.value)
        mList = findViewById(R.id.list)
        mFinish = findViewById(R.id.finish)
        mHistory = findViewById(R.id.history)

        // take pic date and time
        val currentDateTime = LocalDateTime.now()
        time = currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString()

        // show in list

        addToDatabase() // Insert Data in Database



        mName.text = name
        mValue.text = value
        mList.text = stingList

        // ClickListener gor Finish Button
        mFinish.setOnClickListener {
            val intent = Intent(this, FirstPage::class.java)
            startActivity(intent)
            finish()
        }
        // ClickListener gor History Button
        mHistory.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }
    }

    // Add Values in dataBase
    private fun addToDatabase() {
        val db = DataBaseHandler(this)
        var user = User(name , value , stingList , time.toString())
        db.insertData(user)

    }
}
