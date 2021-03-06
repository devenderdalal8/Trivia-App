package com.infinitybiz.triviaapp.View.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.infinitybiz.triviaapp.R

class SecondPageActivity : AppCompatActivity() {
    //Initialize the values
    lateinit var mSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page)
        val sachin = findViewById<RadioButton>(R.id.sachin)
        val virat = findViewById<RadioButton>(R.id.virat)
        val adam = findViewById<RadioButton>(R.id.adam)
        val jacques = findViewById<RadioButton>(R.id.jacques)
        mSubmit = findViewById(R.id.next)
        val mRadioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        // Click Listener for submit Button
        mSubmit.setOnClickListener{
            val selectId : Int = mRadioGroup.checkedRadioButtonId
            val mRadioButton = findViewById<RadioButton>(selectId)
           // check is it null or not
            if (sachin == null && virat == null && adam == null && jacques == null &&selectId == -1
                && null != mRadioButton ) {
                Toast.makeText(this, "Nothing selected", Toast.LENGTH_SHORT).show();
            } else {
                val value = mRadioButton.getText().toString()
                val name = intent.getStringExtra("name")


//                Toast.makeText(this,mRadioButton.getText().toString(), Toast.LENGTH_SHORT).show();
                val intent = Intent(this, ThirdPageActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("value", value)
                startActivity(intent)
            }
        }
    }
}