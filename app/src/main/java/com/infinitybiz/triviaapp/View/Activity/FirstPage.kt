package com.infinitybiz.triviaapp.View.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.infinitybiz.triviaapp.R

class FirstPage : AppCompatActivity() {

    lateinit var mName: EditText
    lateinit var mNext: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_page)

        mName = findViewById(R.id.name)
        mNext = findViewById(R.id.submit)
        mNext.setOnClickListener {
            val name = mName.text.toString()
          // Check it's Empty or not
            if (name.isBlank()) {
                Toast.makeText(this,"Please Fill Your Name !!!" , Toast.LENGTH_SHORT).show()
            } else {
                // Intent the value
                val intent = Intent(this, SecondPageActivity::class.java)
                intent.putExtra("name", mName.text.toString())
                startActivity(intent)
            }
        }
    }
}