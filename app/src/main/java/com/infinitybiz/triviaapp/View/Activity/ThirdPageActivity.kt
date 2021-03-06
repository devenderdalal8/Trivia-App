package com.infinitybiz.triviaapp.View.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.infinitybiz.triviaapp.R

class ThirdPageActivity : AppCompatActivity() {

    lateinit var white : CheckBox
    lateinit var yellow : CheckBox
    lateinit var orange : CheckBox
    lateinit var green : CheckBox
    lateinit var mSubmit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_page)
        addListenerOnClick()
    }

    private fun addListenerOnClick() {
        white = findViewById(R.id.white)
        yellow = findViewById(R.id.yellow)
        orange = findViewById(R.id.orange)
        green = findViewById(R.id.green)
        mSubmit = findViewById(R.id.home)

        mSubmit.setOnClickListener{
            val list : ArrayList<String> = arrayListOf()
            // check which list is check which is not
            if(white.isChecked){
                list.add("White")
            }
            if(yellow.isChecked){
                list.add("Yellow")
            }
            if(orange.isChecked){
                list.add("Orange")
            }
            if(green.isChecked){
                list.add("Green")
            }
            val name =intent.getStringExtra("name")
            val value =intent.getStringExtra("value")
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name" , name)
            intent.putExtra("value" , value)
            intent.putExtra("list" , list)
            startActivity(intent)
        }
    }
}