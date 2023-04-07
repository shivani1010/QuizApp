package com.tutrials.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart: Button =findViewById(R.id.btn_start)
        val etName:EditText = findViewById(R.id.et_name)

        btnStart.setOnClickListener{
            if(etName.text.isEmpty())
            {
                etName.error="Please Enter Your Name"

            }else{
               val intent=Intent(this,QuizQuetionActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}