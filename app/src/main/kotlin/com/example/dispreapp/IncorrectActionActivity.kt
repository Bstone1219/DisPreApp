package com.example.dispreapp

import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_correct_action.*
import kotlinx.android.synthetic.main.activity_main.*

/***************************
 画面名：行ってはいけない行動
****************************/

class IncorrectActionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_incorrect_action)

        val toTop = findViewById<TextView>(R.id.toTop)

        toTop.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        toTop.movementMethod = LinkMovementMethod.getInstance()
        toTop.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        backButton.setOnClickListener {
            finish()
        }
    }
}
